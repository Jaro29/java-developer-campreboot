package pl.coderslab.homeworks.strings;


import static java.lang.Character.isUpperCase;

public class Main06 {

    public static void main(String[] args) {

        String str = "Zażółć gęślą jaźń";
        String str2 = "ACBRŃĘ JHVNĆ ŁCĄP";
        System.out.println(decode(str2, 3));
    }

    public static String encode(String str, int shift) {
        char[] alfabet = "AĄBCĆDEĘFGHIJKLŁMNŃOÓPQRSŚTUVWXYZŹŻ".toCharArray();
//        char[] alfabet = "AĄBCĆDEĘFGHIJKLŁMNŃOÓPQRSŚTUVWXYZŹŻaąbcćdeęfghijklłmnńoópqrsśtuvwxyzźż".toCharArray();

        char[] toEncode = str.toUpperCase().toCharArray();
//        char[] toEncode = str.toCharArray();

        for (int i = 0; i < toEncode.length; i++) {
            for (int j = 0; j < alfabet.length; j++) {
                if (toEncode[i] == alfabet[j]) {

                    toEncode[i] = alfabet[(j + shift) % alfabet.length];

                    break;
                }
            }
        }

        return new String(toEncode);
    }

    public static String decode(String str, int shift) {
        char[] alfabet = "AĄBCĆDEĘFGHIJKLŁMNŃOÓPQRSŚTUVWXYZŹŻ".toCharArray();
//        char[] alfabet = "AĄBCĆDEĘFGHIJKLŁMNŃOÓPQRSŚTUVWXYZŹŻaąbcćdeęfghijklłmnńoópqrsśtuvwxyzźż".toCharArray();

        char[] toDecode = str.toUpperCase().toCharArray();
//        char[] toEncode = str.toCharArray();

        for (int i = 0; i < toDecode.length; i++) {
            for (int j = 0; j < alfabet.length; j++) {
                if (toDecode[i] == alfabet[j]) {

                    toDecode[i] = alfabet[(j - shift + alfabet.length) % alfabet.length];

                    break;
                }
            }
        }

        return new String(toDecode);
    }

    public static String encode3(String str, int shift) {
        String alfabet = "AĄBCĆDEĘFGHIJKLŁMNŃOÓPQRSŚTUVWXYZŹŻ";
        StringBuilder coded = new StringBuilder();
        for (int i = 0; i < str.length(); i++) {
            for (int j = 0; j < alfabet.length(); j++) {
//                if (isUpperCase(str.charAt(i))) {
                if (str.toUpperCase().charAt(i) == alfabet.charAt(j)) {
                    coded.append(alfabet.charAt((j + shift) % alfabet.length()));
                }
            }
//            break;
        }

        return coded.toString();
    }

    public static String encode2(String str, int shift) {
        String matrix = "AĄBCĆDEĘFGHIJKLŁMNŃOÓPQRSŚTUVWXYZŹŻ";
        char[] coded = new char[str.length()];
        for (int i = 0; i < str.length(); i++) {
            if (Character.isLetter(str.charAt(i))) {
                for (int k = 0; k < matrix.length(); k++) {
                    if (str.charAt(i) == matrix.charAt(k)) {
                        coded[i] = matrix.charAt((k + shift) % matrix.length());
                    }

                    /*
                    if (str.charAt(i) == matrix.charAt(k) && k < matrix.length() - shift) {
                        coded[i] = matrix.charAt(k + shift);
                    } else
                    if (str.charAt(i) == matrix.charAt(k) && k >= matrix.length() - shift) {
                        coded[i] = matrix.charAt(k - matrix.length() + shift);
                    }
                     */

                }
            } else {
                coded[i] = str.charAt(i);
            }
        }
        return new String(coded);
    }
}