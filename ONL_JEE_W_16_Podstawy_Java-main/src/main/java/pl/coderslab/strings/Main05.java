package pl.coderslab.strings;

public class Main05 {

    public static void main(String[] args) {

        String[] str = {"CodersLab", " jak", " dobrze zacząć programować"};
        System.out.println(stringFromArray(str));
    }

    static String stringFromArray(String[] str) {
        String concatText = "";
        for (int i = 0; i < str.length; i++) {
            concatText = concatText.concat(str[i]);
        }
        return concatText;
    }

}
