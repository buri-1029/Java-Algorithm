package baek.silver;

import java.util.Scanner;

// *****
public class B1645_랜선자르기 {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int K = scan.nextInt();
		int N = scan.nextInt();

		int[] arr = new int[K];
		long max = 0;
		long min = 0;

		for (int i = 0; i < arr.length; i++) {
			arr[i] = scan.nextInt();

			if (max < arr[i]) {
				max = arr[i];
			}
		}

		max++;

		while (min < max) {
			long mid = (max + min) / 2;
			long cnt = 0;

			for (int i : arr) {
				cnt += (i / mid);
			}

			if (cnt < N) {
				max = mid;
			} else {
				min = mid + 1;
			}

		}

		System.out.println(min - 1);
	}

}