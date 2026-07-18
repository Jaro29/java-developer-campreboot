package pl.coderslab.advanced.generics;

public class Main02 {

    public static void main(String[] args) {
        Integer[] ints = {0, 1, 1, 2, 2, 2, 2, 3, 6, 6, 8, 22, 22, 22, 1, 4, 6, 8, 9, 23};
        System.out.println(countOccurrences(ints,1));
        String[] words = {"", "dom","miasto","ulica","dom","dzielnica","dom","","aa","aa","aa"};
        System.out.println(countOccurrences(words,"dom"));
    }

    public static <T> int countOccurrences(T[] array, T target) {
        int count = 0;
        for (T element : array) {
            if (element.equals(target)) {
                count++;
            }
        }
        return count;
    }
}
