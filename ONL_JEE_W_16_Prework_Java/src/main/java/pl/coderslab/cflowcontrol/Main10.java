package pl.coderslab.cflowcontrol;

public class Main10 {

    public static void main(String[] args) {

        int n = 5;
        for (int i = 0; i < 5; i++) {
            //String row = "*";
            for (int j = 0; j < n; j++) {

                if (i >= j) {
                    System.out.print("*");
                } else {
                    System.out.print(j + 1);
                }
            }
            System.out.println();
        }
    }
}
/*
        int n = 5;
        for (int i = 0; i < 10; i++) {
            for (int j = 1; j <= n; j++) {
                if (j <= n - j - 4) {
                    System.out.print("*");
                } else {
                    System.out.print(j + 2);
                }
            }
            //for (int j = i + 2; j <= n; j++) {
            //    System.out.print(j);
            System.out.println();
        }
    }

}

        int n = 5;
        for (int i = 0; i < n; i++) {

            //Gwiazdki
            for (int j = 0; j <= i; j++) {
                System.out.print("*");
            }
            //Cyfry
            for (int j = i + 2; j <= n; j++) {
                System.out.print(j);
            }
            System.out.print("\n");
        }

        * 2 3 4 5   j=1  n-j=4
        * * 3 4 5   j=2  n-j=3
        * * * 4 5   j=3      2
        * * * * 5   j=4      1
        * * * * *   j=5  n-j=0
        * * * * *
        * * * * 5
        * * * 4 5
        * * 3 4 5
        * 2 3 4 5
*/