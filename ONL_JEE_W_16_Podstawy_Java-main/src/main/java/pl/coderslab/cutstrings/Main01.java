package pl.coderslab.cutstrings;

public class Main01 {

    public static void main(String[] args) {

        String str = "Naucz się programować od podstaw i rozwiń wymarzoną karierę w branży IT.";
        String[] words = str.split(" ");
        for (String word : words) {
            System.out.println(word);
        }
    }
}
