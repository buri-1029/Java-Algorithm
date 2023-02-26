package baek.bronze;

import java.util.Scanner;

public class B2846_오르막길 {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int N = scan.nextInt();

		int[] arr = new int[N];

		for (int i = 0; i < N; i++) {
			arr[i] = scan.nextInt();
		}

		int sum = 0;
		int answer = 0;

		for (int i = 0; i < N - 1; i++) {
			if (arr[i] < arr[i + 1]) {
				sum += (arr[i + 1] - arr[i]);
			} else {
				sum = 0;
			}

			answer = Math.max(answer, sum);
		}

		System.out.println(answer);
	}
}
