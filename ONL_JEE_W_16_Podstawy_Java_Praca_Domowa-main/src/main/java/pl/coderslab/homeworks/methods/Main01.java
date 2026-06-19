package pl.coderslab.homeworks.methods;


public class Main01 {

    public static void main(String[] args) {
        System.out.println(dogAge(7));

    }

    public static double dogAge(double dogAge) {
        double humAge = 0;
        if (dogAge <= 2) {
            humAge = dogAge * 10.5;
        } else if (dogAge > 2) {
            humAge = 21 + (dogAge - 2) * 4;
        }
        return humAge;
    }
}
