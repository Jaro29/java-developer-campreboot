package pl.coderslab.exceptions;


public class Main05 {

    public static void main(String[] args) {
        try {

            int num = Integer.parseInt("123a");
            System.out.println(num);
        } catch (NumberFormatException e) {
            System.out.println("Daj cyfry jako argument.\n" + e);
        } finally {
            System.out.println("This is the End,\nmy only friend.");
        }
    }

}
