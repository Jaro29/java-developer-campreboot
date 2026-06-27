package pl.coderslab.externaljar;


import org.apache.commons.lang3.StringUtils;

public class Main01 {

    public static void main(String[] args) {
        System.out.println(reverseString("Tak"));
    }

    public static String reverseString(String str) {
        return StringUtils.reverse(str);
    }
}
