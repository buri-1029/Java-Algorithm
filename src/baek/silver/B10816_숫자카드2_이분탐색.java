package baek.silver;

import java.util.Arrays;
import java.util.Scanner;

public class B10816_숫자카드2_이분탐색 {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int N = scan.nextInt();
		int[] arr = new int[N];

		for (int i = 0; i < N; i++) {
			arr[i] = scan.nextInt();
		}

		Arrays.sort(arr);

		int M = scan.nextInt();

		StringBuilder sb = new StringBuilder();

		for (int i = 0; i < M; i++) {
			int key = scan.nextInt();

			sb.append(upperBound(arr, key) - lowerBound(arr, key))
			  .append(' ');
			// sout >> 시간초과
		}

		System.out.println(sb);
	}

	private static int lowerBound(int[] arr, int key) {
		int lo = 0;
		int hi = arr.length;

		while (lo < hi) {
			int mid = (lo + hi) / 2;

			if (key <= arr[mid]) {
				hi = mid;
			} else {
				lo = mid + 1;
			}
		}

		return lo;
	}

	private static int upperBound(int[] arr, int key) {
		int lo = 0;
		int hi = arr.length;

		while (lo < hi) {
			int mid = (lo + hi) / 2;

			if (key < arr[mid]) {
				hi = mid;
			} else {
				lo = mid + 1;
			}
		}

		return lo;
	}

}
