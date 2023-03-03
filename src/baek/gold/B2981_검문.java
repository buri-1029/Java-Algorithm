package baek.gold;

import java.util.Arrays;
import java.util.Scanner;

public class B2981_검문 {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int N = scan.nextInt();

		int[] arr = new int[N];

		for (int i = 0; i < N; i++) {
			arr[i] = scan.nextInt();
		}

		Arrays.sort(arr);

		int gcd = arr[1] - arr[0];

		for (int i = 2; i < N; i++) {
			gcd = gcd(gcd, arr[i] - arr[i - 1]);
		}

		for (int i = 2; i <= gcd; i++) {
			if (gcd % i == 0) {
				System.out.print(i + " ");
			}
		}

	}

	public static int gcd(int a, int b) {
		while (b != 0) {
			int r = a % b;
			a = b;
			b = r;
		}

		return a;
	}
}
