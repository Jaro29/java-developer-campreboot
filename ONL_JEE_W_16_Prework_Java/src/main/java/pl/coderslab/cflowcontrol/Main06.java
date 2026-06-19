package pl.coderslab.cflowcontrol;

public class Main06 {

	public static void main(String[] args) {
		int n = 6;
		for (int i = 0; i <= n; i++) {
			String a;
			if (i%2 == 0){
				a = "parzysta";
			}
			else a = "nieparzysta";
			System.out.println(i + " - " + a);
		}
		int i = 0;
		while ( i <= n) {
			String a;
			if (i%2 == 0){
				a = "parzysta";
			}
			else a = "nieparzysta";
			System.out.println(i + " - " + a);
			i++;
		}
	}


}
