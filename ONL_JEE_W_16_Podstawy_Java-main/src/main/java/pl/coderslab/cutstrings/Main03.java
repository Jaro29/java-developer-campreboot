package pl.coderslab.cutstrings;

public class Main03 {

    public static void main(String[] args) {
        System.out.println(countTokens(" To jest tekst do "));

    }

    public static int countTokens(String str){
        return str.trim().split(" ").length;
    }
}
