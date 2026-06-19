package pl.coderslab.exceptions;

public class Main03 {

    public static void main(String[] args) {
        showLength(null);
    }

    static void showLength(String s) {
        if (s != null) {

            System.out.println(s.length());
        } else {
            System.out.println("Argument nie może być null.");
        }
    }

}


// NullPointerException