package pl.coderslab.regex;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main01 {

    public static void main(String[] args) {
        System.out.println(verifyEmail("jaro@gmail,com"));
    }

    static boolean verifyEmail(String email) {
        Pattern compiledPattern =
                Pattern.compile("[_a-zA-Z0-9-]+(\\.[_a-zA-Z0-9-]+)*@" +
                        "[a-zA-Z0-9-]+(\\.[a-zA-Z0-9-]+)*\\.([a-zA-Z]{2,}){1}");
        Matcher matcher = compiledPattern.matcher(email);

        return matcher.matches();
    }
}
