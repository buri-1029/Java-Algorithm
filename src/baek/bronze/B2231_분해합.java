package baek.bronze;

import java.util.Scanner;

public class B2231_분해합 {

	public static void main(String[] args) {

		Scanner scan = new Scanner(System.in);

		int N = scan.nextInt();

		int answer = 0;

		for (int i = 0; i < N; i++) {
			int number = i;
			int sum = 0;

			while (number != 0) {
				sum += number % 10;
				number /= 10;
			}

			if (sum + i == N) {
				answer = i;
				break;
			}
		}

		System.out.println(answer);
	}
}
