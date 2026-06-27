package pl.coderslab.externaljar;

import org.apache.commons.lang3.StringUtils;

public class Main04 {

    public static void main(String[] args) {
        System.out.println(checkPalindrome("ma a Na a M"));
    }

    public static boolean checkPalindrome(String str) {
        String cleanStr = StringUtils.deleteWhitespace(str.toLowerCase());
        return cleanStr.equals(StringUtils.reverse(cleanStr));
    }
}
