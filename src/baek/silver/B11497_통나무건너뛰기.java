package baek.silver;

import java.util.Arrays;
import java.util.Scanner;

public class B11497_통나무건너뛰기 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();

		for (int t = 0; t < T; t++) {
			int N = sc.nextInt();
			int[] arr = new int[N];

			for (int i = 0; i < N; i++) {
				arr[i] = sc.nextInt();
			}

			Arrays.sort(arr);

			int left = N - 1;
			int right = 0;
			int[] tmp = new int[N];

			for (int i = 0; i < N; i++) {
				if (i % 2 == 0) {
					tmp[left--] = arr[i];
				} else {
					tmp[right++] = arr[i];
				}
			}

			int answer = 0;
			for (int i = 1; i < N; i++) {
				answer = Math.max(answer, Math.abs(tmp[i] - tmp[i - 1]));
			}
			answer = Math.max(answer, Math.abs(tmp[0] - tmp[N - 1]));

			System.out.println(answer);
		}
	}

}
