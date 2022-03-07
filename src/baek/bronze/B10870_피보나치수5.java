package baek.bronze;

import java.util.Scanner;

public class B10870_피보나치수5 {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int n = scan.nextInt();

		System.out.println(fibo(n));
	}

	private static int fibo(int n) {
		if (n == 0) {
			return 0;
		} else if (n == 1) {
			return 1;
		}

		return fibo(n - 1) + fibo(n - 2);
	}
}
