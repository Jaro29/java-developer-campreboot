package pl.coderslab.exceptions;


public class Main01 {

    public static void main(String[] args) {
        try {
            System.out.println(factorial(2));
        } catch (IllegalArgumentException e) {
            System.err.println("1 " + e);
            System.out.println("2 " + e.getMessage());
            System.out.println("3 " + e);
            System.err.println("4 " + e.getMessage());
            e.printStackTrace();

        }
    }

    static int factorial(int number) {

        if (number < 0) {
            throw new IllegalArgumentException("Niepoprawna wartość: " + number + " Jako argument podaj liczbę większą od 0.");
        } else {
            int result = 1;
            for (int i = 1; i <= number; i++) {
                result *= i;

            }
            return result;
        }
    }
}
