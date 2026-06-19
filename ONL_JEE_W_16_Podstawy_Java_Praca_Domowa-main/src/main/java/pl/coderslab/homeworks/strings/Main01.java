package pl.coderslab.homeworks.strings;


public class Main01 {

    public static void main(String[] args) {
        String str = "CodersLab";
        System.out.println(replaceChar(str, 'L', 'D'));
    }

    public static String replaceChar(String str, char forReplace, char replacement) {
        char[] strArray = str.toCharArray();
        for (int i = 0; i < strArray.length; i++) {
            if (strArray[i] == forReplace) {
                strArray[i] = replacement;
            }
        }

        return new String(strArray);
    }

}
