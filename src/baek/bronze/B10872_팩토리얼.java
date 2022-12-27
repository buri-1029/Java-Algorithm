package baek.bronze;

import java.util.Scanner;

public class B10872_팩토리얼 {

	public static void main(String[] args) {

		Scanner scan = new Scanner(System.in);
		int N = scan.nextInt();

		//	int sum = factorial(N);

		int sum = 1;

		while (N != 0) {
			sum = sum * N;
			N--;
		}

		System.out.println(sum);

	}

	public static int factorial(int N) {
		if (N <= 1) {
			return 1;
		}

		return N * factorial(N - 1);
	}
}
