package baek.silver;

import java.util.Scanner;

public class B2003_수들의합 {

	public static void main(String args[]) {
		Scanner sc = new Scanner(System.in);

		int n = sc.nextInt();
		int m = sc.nextInt();

		int[] arr = new int[n];

		for (int i = 0; i < n; i++) {
			arr[i] = sc.nextInt();
		}

		System.out.println(twoPointer(arr, m));
	}

	public static int twoPointer(int[] arr, int m) {
		int cnt = 0;
		int start = 0, end = 0;
		int sum = 0;

		while (true) {
			if (sum >= m) {
				sum -= arr[start++];
			} else if (end >= arr.length) {
				break;
			} else {
				sum += arr[end++];
			}

			if (sum == m) {
				cnt++;
			}
		}

		return cnt;
	}
}
