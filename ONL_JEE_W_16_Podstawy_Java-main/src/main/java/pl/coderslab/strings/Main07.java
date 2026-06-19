package pl.coderslab.strings;

public class Main07 {

    public static void main(String[] args) {

        String str = "Lola";

        String palinStr = str.toLowerCase().replace(" ", "");
        System.out.println(palinStr);

        for (int i = 0; i < palinStr.length() / 2; i++) {
            if (palinStr.charAt(i) != palinStr.charAt(palinStr.length() - i - 1)) {
                System.out.println(str + " nie jest palindromem");
                break;
            } else if (i == palinStr.length() / 2 - 1) {
                System.out.println(str + " jest palindromem");
            }


        }


    }
}
