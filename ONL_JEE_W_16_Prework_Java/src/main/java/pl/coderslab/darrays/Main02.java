package pl.coderslab.darrays;

public class Main02 {

    public static void main(String[] args) {
        String[] fruits = new String[3];
        fruits[0] = "apple";
        fruits[2] = "berry";
        fruits[1] = "banana";
        System.out.println(fruits[0]);
        System.out.println(fruits[fruits.length - 1]);
        for (int i = 0; i < fruits.length; i++) {
            System.out.println(fruits[i]);
        }
    }

}
