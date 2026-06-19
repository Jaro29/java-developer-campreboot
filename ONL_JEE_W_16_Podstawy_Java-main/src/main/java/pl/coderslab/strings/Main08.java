package pl.coderslab.strings;

import java.util.Arrays;

import static java.lang.Character.*;

public class Main08 {

    public static void main(String[] args) {
        System.out.println(toggleChar("Tak"));
    }

    static String toggleChar(String str) {

        char[] strArray = str.toCharArray();
        String invert = "";
        for (int i = 0; i < strArray.length; i++) {
            if (isLowerCase(strArray[i])) {
                invert += toUpperCase(strArray[i]);
            } else {
                invert += toLowerCase(strArray[i]);
            }
        }
        return invert;
    }
}
