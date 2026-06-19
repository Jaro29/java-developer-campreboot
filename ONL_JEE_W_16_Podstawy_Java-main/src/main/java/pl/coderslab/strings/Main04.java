package pl.coderslab.strings;

public class Main04 {

    public static void main(String[] args) {

        String str = "CodersLab";
        System.out.println(containsStr(str, "erS"));
    }

    static boolean containsStr(String str, String search){

        return str.contains(search);
    }
}
