package baek.silver;

import java.util.Scanner;

public class B2581_소수 {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int M = scan.nextInt();
		int N = scan.nextInt();

		int sum = 0;
		int min = N;
		for (int i = M; i <= N; i++) {
			if (prime(i)) {
				sum += i;
				min = Math.min(min, i);
			}
		}

		if (sum == 0) {
			System.out.println(-1);
		} else {
			System.out.println(sum);
			System.out.println(min);
		}
	}

	private static boolean prime(int n) {
		if (n < 2) {
			return false;
		}

		for (int i = 2; i * i <= n; i++) {
			if (n % i == 0) {
				return false;
			}
		}

		return true;
	}
}
