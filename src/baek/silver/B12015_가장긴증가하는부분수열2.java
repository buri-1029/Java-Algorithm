package baek.silver;

import java.util.Scanner;

/*
 * 다시 해보기(st-lab 블로그 참고)
 */

public class B12015_가장긴증가하는부분수열2 {

	public static void main(String[] args) {

		Scanner scan = new Scanner(System.in);
		int N = scan.nextInt();

		int[] arr = new int[N];
		int[] LIS = new int[N];

		for (int i = 0; i < N; i++) {
			arr[i] = scan.nextInt();
		}

		LIS[0] = arr[0];
		int len = 1; // length Of LIS

		for (int i = 1; i < N; i++) {

			int key = arr[i];

			if (LIS[len - 1] < key) {
				len++;
				LIS[len - 1] = key;
			} else {
				int lo = 0;
				int hi = len;

				while (lo < hi) {
					int mid = (lo + hi) / 2;

					if (LIS[mid] < key) {
						lo = mid + 1;
					} else {
						hi = mid;
					}

				}

				LIS[lo] = key;

			}

		}

		System.out.println(len);
	}
}
