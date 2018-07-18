package app;

import pojos.RateFluctuation;

public class Test {
    public static void main(String[] args) {
        RateFluctuation r1 = new RateFluctuation("TSLA", 297.57, 319.36, 6.82);
        RateFluctuation r2 = new RateFluctuation("TSLA", 297.57, 319.36, 6.82);

        System.out.println(r1.equals(r2));
    }
}
