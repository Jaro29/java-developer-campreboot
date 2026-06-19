package pl.coderslab.cutstrings;

import java.util.Arrays;

public class Main04 {

    public static void main(String[] args) {
        String str = "Naucz się programować od podstaw i rozwiń wymarzoną karierę w branży IT.";
        System.out.println(Arrays.toString(onlyTwoElements(str, ' ')));
    }

    public static String[] onlyTwoElements(String str, char separator) {
        String[] twoEleArray = new String[2];
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i)==separator){
                twoEleArray[0]=str.substring(0,i);
                twoEleArray[1]=str.substring(i+1);
                break;
            }
        }
        return twoEleArray;
    }
}
