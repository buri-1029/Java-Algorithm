package baek.silver;

import java.util.Arrays;
import java.util.Scanner;

public class B10815_숫자카드 {

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
			int answer = binarySearch(arr, scan.nextInt());

			if (answer != -1) {
				sb.append(1)
				  .append(' ');
			} else {
				sb.append(0)
				  .append(' ');
			}
		}

		System.out.println(sb);
	}

	private static int binarySearch(int[] arr, int key) {
		int left = 0;
		int right = arr.length - 1;

		while (left <= right) {
			int mid = (left + right) / 2;

			if (key < arr[mid]) {
				right = mid - 1;
			} else if (key > arr[mid]) {
				left = mid + 1;
			} else {
				return mid;
			}
		}

		return -1;
	}
}
