package pl.coderslab.estartupparameters;

public class Main07 {

    public static void main(String[] args) {
        int n = Integer.parseInt(args[0]);
        int factorial = 1;
        for (int i = 1; i <= n; i++) {
            factorial = factorial * n;
        }
        System.out.println(factorial);
    }

}
