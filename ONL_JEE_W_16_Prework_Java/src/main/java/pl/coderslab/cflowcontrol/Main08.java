package pl.coderslab.cflowcontrol;

public class Main08 {

    public static void main(String[] args) {
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
    }
}

