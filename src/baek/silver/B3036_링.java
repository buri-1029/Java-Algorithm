package baek.silver;

import java.util.Scanner;

public class B3036_링 {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int N = scan.nextInt();

		int first = scan.nextInt();

		for (int i = 1; i < N; i++) {

			int other = scan.nextInt();

			int gcd = gcd(first, other);

			System.out.println((first / gcd) + "/" + (other / gcd));
		}
	}


	private static int gcd(int a, int b) {
		int tmp;

		while (b != 0) {
			tmp = a % b;
			a = b;
			b = tmp;
		}

		return a;
	}
}
