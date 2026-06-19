package pl.coderslab.exceptions;

public class Main02 {

    public static void main(String[] args) {
        int[] tab = {5, 1, 6, 7, 8};
        try {

            System.out.println(tab[2]);
        } catch (ArrayIndexOutOfBoundsException e) {
            System.err.println("2 " + e.getMessage());
            e.printStackTrace();
        }
    }

}


// ArrayIndexOutOfBoundsException