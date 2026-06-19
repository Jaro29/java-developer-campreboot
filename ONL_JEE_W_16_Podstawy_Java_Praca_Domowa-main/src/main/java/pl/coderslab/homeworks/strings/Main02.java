package pl.coderslab.homeworks.strings;


public class Main02 {

    public static void main(String[] args) {
        System.out.println(replaceStr("CodersLab CodersLab","Co","XxX"));

    }

    public static String replaceStr(String str, String forReplace, String replacement) {
        return str.replaceAll(forReplace, replacement);
    }
}
