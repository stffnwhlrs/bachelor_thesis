package app;

import pojos.RateFluctuation;

public class Test {
    public static void main(String[] args) {
//        RateFluctuation r1 = new RateFluctuation("TSLA", 297.57, 319.36, 6.82);
//        RateFluctuation r2 = new RateFluctuation("TSLA", 297.57, 319.36, 6.82);

        String s1 = "Tesla";
        String s2 = "tesla";
        String s3 = "dsadsTesladas";

        System.out.println(s1.contains("tesla"));
        System.out.println(s2.contains("Tesla"));
        System.out.println(s3.contains("Tesla"));

    }
}
