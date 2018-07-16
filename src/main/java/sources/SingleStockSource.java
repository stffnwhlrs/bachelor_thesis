package sources;

import org.apache.flink.streaming.api.functions.source.SourceFunction;

import java.util.Random;

public class SingleStockSource implements SourceFunction<String> {

    private volatile boolean _isRunning = true;
    private int _count = 0;
    private String _symbol;
    private double _price;
    private  Random _random;
    private int _sigma;

    public SingleStockSource (String symbol, double price, int sigma) {
        _symbol = symbol;
        _price = price;
        _random =new Random();
        _sigma = sigma;
    }

    @Override
    public void run(SourceContext<String> sourceContext) throws InterruptedException {
        while (_isRunning && _count < 200) {
            _price = _price +  _random.nextGaussian() * _sigma;
            _price = _price * 100;
            _price = Math.round(_price);
            _price = _price / 100;
            String result = _symbol + ", " + _price;
            sourceContext.collect(result);
            Thread.sleep(_random.nextInt(200));
            _count ++;
        }
    }

    @Override
    public void cancel() {
        _isRunning = false;
    }
}
