package pl.coderslab.estartupparameters;

import java.util.Locale;

public class Main03 {
    public static void main(String[] args) {
//int param3 = Integer.parseInt(args[2]);
        double avg;
        double sum = 0;

        for (String arg: args){
            double param = Double.parseDouble(arg);
            sum = sum + param;
        }
        avg=sum/args.length;
        //System.out.printf(Locale.ENGLISH, "ŚREDNIA: %.2f%n", avg);
        System.out.printf(Locale.of("pl", "PL"), "ŚREDNIA: %.2f\n", avg);
    }
}
