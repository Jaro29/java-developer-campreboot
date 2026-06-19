package pl.coderslab.darrays;

import java.util.Locale;

public class Main07 {

    public static void main(String[] args) {
        double[] temps = {30, 29, 14, 42, -4, -10, 8, 14, 32, 11, 8, 0, 0};

        //tempCelc * 1.8 + 32
        double sum = 0;
        for (int i = 0; i < temps.length; i++) {
            temps[i] = temps[i] * 1.8 + 32;
            sum = sum + temps[i];
        }
        double avg = sum / temps.length;
        System.out.printf(Locale.ENGLISH, "ŚREDNIA: %.2f%n", avg);

    }

}
