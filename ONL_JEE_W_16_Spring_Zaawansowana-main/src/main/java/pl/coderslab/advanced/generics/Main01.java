package pl.coderslab.advanced.generics;

public class Main01 {
    public static void main(String[] args) {
        System.out.println(max(5, 10));
        System.out.println(max("banan", "jabłko"));
    }
    public static <T extends Comparable<T>> T max(T a, T b) {
        return a.compareTo(b) >= 0 ? a : b;
    }
}
