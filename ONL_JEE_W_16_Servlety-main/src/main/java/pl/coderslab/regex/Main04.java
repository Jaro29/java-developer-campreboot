package pl.coderslab.regex;

import java.util.regex.Pattern;

public class Main04 {

  public static void main(String[] args) {
        boolean result1 = Pattern.matches("(\\w+)=\\1", "Ala=Ala");
        System.out.println(result1);

        boolean result2 = Pattern.matches("\\.", ".");
        System.out.println(result2);

        boolean result3 = Pattern.matches("abc+", "abcccc");
        System.out.println(result3);

        boolean result4 = Pattern.matches("abc.", "abcw");
        System.out.println(result4);

        String pat1 = "abc\\.";
        boolean result5 = Pattern.matches(pat1, "abc.");
        System.out.println(result5);


        Pattern pattern1 = Pattern.compile("^abc");
        boolean result6 = pattern1.matcher("Nazywam sie abc").find();
        System.out.println(result6);

        boolean result7 = pattern1.matcher("abc to moje imie").find();
        System.out.println(result7);

        Pattern pattern2 = Pattern.compile("abc$");
        boolean result8 = pattern2.matcher("Nazywam sie abc").find();
        System.out.println(result8);

        boolean result9 = pattern2.matcher("abc to moje imie").find();
        System.out.println(result9);

        boolean result10 = Pattern.matches("[0-9]", "1");
        System.out.println(result10);

        boolean result11 = Pattern.matches("^\\d{2}-\\d{3}$", "09-522");
        System.out.println(result11);

    }
}
