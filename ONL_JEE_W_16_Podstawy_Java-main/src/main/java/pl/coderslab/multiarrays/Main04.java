package pl.coderslab.multiarrays;

public class Main04 {

    public static void main(String[] args) {

        int[][] task4Array = {
                {2, 3, 4, 6},
                {12, 32, 12, 11},
                {3, 2, 1, 4},
                {5, 1, 6, 7}};
        int matrixPrint = 0;
        for (int i = 0; i < task4Array.length; i++)
            for (int j = 0; j < task4Array[i].length; j++)
                if (i == j) matrixPrint = matrixPrint + task4Array[i][j];
        System.out.println(matrixPrint);
    }


}
