package pl.coderslab.strings;

public class Main02 {

    public static void main(String[] args) {
        String str = "CodersLab jak dobrze zacząć programować";
        System.out.println(charPos(str, 'c'));
    }

    public static int charPos(String str, char c) {
        int i;
        for (i = 0; i < str.length(); i++) {
            if (str.charAt(i) == c) {
                break;
            }
        }
        return i;
    }
}
