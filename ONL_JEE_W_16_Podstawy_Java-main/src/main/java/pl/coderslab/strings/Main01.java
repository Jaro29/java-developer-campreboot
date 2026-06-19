package pl.coderslab.strings;

public class Main01 {


    public static void main(String[] args) {

        String str = "CodersLab jak dobrze zacząć programować";

        char notLast = str.charAt(str.length() - 2);
        int sum = 0;
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) == notLast) {
                sum += 1;
            }
        }
        System.out.println(sum);

    }
}
