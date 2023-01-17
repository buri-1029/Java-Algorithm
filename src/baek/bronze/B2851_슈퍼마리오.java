package baek.bronze;

import java.util.Scanner;

public class B2851_슈퍼마리오 {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);

		int sum = 0;
		int answer = 0;

		for (int i = 0; i < 10; i++) {
			int num = scan.nextInt();

			if (sum < 100) {
				sum += num;

				if (Math.abs(answer - 100) > Math.abs(sum - 100)) {
					answer = sum;
				} else if (Math.abs(answer - 100) == Math.abs(sum - 100)) {
					answer = Math.max(answer, sum);
				}
			}
		}

		System.out.println(answer);

	}
}
