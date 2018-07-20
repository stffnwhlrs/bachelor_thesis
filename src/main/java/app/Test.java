package app;

import java.io.Serializable;

    public class Test implements Serializable {

    public static void main(String[] args) throws Exception {
        double result;
        int x;
        int y;

        x = 2;
        y = 3;

        result = (double) x / y;

        System.out.println(result);

    }
}
