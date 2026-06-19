package pl.coderslab.estartupparameters;

public class Main08 {

    public static void main(String[] args) {
        int a = Integer.parseInt(args[0]);
        int b = Integer.parseInt(args[1]);
        int r;
        while (b > 0) {
            r = a % b;
            a = b;
            b = r;
        }
        System.out.println("GCD: " + a);
    }

}
