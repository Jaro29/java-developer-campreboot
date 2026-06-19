package pl.coderslab.methods;

public class Main07 {

    public static void main(String[] args) {
        System.out.println(checkEvenOdd(17));
    }

    public static String checkEvenOdd(int number) {
        String evenness;
        if (number % 2 == 0) {
            evenness = "even";
        } else evenness = "odd";

        return evenness;
    }
}
