package pl.coderslab.strings;

public class Main06 {

    public static void main(String[] args) {

        String str = "codersLabxyz";

        String invert = "";
        for (int i = 0; i < str.length(); i++) {
            invert += str.charAt(str.length() - i - 1);
        }
        System.out.println(invert);
    }
}

