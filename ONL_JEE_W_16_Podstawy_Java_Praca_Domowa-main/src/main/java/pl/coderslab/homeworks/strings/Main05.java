package pl.coderslab.homeworks.strings;


public class Main05 {

    public static void main(String[] args) {

        String str = "Juliusz Cezar";
        System.out.println(encode(str));

    }

    public static String encode(String str) {
        char[] alfabet = "AĄBCĆDEĘFGHIJKLŁMNŃOÓPQRSŚTUVWXYZŹŻAĄBC".toCharArray();
        char[] toEncode = str.toUpperCase().toCharArray();
        for (int i = 0; i < toEncode.length; i++) {
            for (int j = 0; j < alfabet.length; j++) {
                if (toEncode[i] == alfabet[j]) {
                    toEncode[i] = alfabet[j + 3];
                    break;
                }
            }
        }

        return new String(toEncode);
    }
}
