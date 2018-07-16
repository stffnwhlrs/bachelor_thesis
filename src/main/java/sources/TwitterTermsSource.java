package sources;

import com.twitter.hbc.core.endpoint.StatusesFilterEndpoint;
import com.twitter.hbc.core.endpoint.StreamingEndpoint;
import org.apache.flink.streaming.connectors.twitter.TwitterSource;

import java.io.Serializable;
import java.util.Arrays;
import java.util.List;

public class TwitterTermsSource implements TwitterSource.EndpointInitializer, Serializable {

    private static final List<String> TERMS = Arrays.asList("Tesla", "TSLA", "Elon Musk");

    public TwitterTermsSource() {}

    @Override
    public StreamingEndpoint createEndpoint() {
        StatusesFilterEndpoint endpoint = new StatusesFilterEndpoint();
        endpoint.trackTerms(TERMS);
        return endpoint;
    }
}
