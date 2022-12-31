package baek.silver;

import java.util.Scanner;

public class B2805_나무자르기 {

	public static void main(String[] args) {

		Scanner scan = new Scanner(System.in);

		int N = scan.nextInt();
		int M = scan.nextInt();

		int[] arr = new int[N];

		int min = 0;
		int max = 0;

		for (int i = 0; i < N; i++) {
			arr[i] = scan.nextInt();

			if (max < arr[i]) {
				max = arr[i];
			}
		}

		while (min < max) {

			int mid = (min + max) / 2;
			long sum = 0;

			for (int n : arr) {
				if (n - mid > 0) {
					sum += (n - mid);
				}
			}

			if (sum < M) {
				max = mid;
			} else {
				min = mid + 1;
			}
		}

		System.out.println(min - 1);
	}
}
