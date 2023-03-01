package baek.silver;

import java.util.Arrays;
import java.util.Scanner;

public class B7795_먹을것인가먹힐것인가 {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int T = scan.nextInt();

		for (int t = 0; t < T; t++) {
			int N = scan.nextInt();
			int M = scan.nextInt();

			int[] A = new int[N];
			int[] B = new int[M];

			for (int i = 0; i < N; i++) {
				A[i] = scan.nextInt();
			}

			for (int i = 0; i < M; i++) {
				B[i] = scan.nextInt();
			}

			Arrays.sort(B);

			int answer = 0;

			for (int i = 0; i < N; i++) {
				int left = 0;
				int right = M - 1;
				int index = 0;

				while (left <= right) {
					int mid = (left + right) / 2;
					if (B[mid] < A[i]) {
						left = mid + 1;
						index = mid + 1;
					} else {
						right = mid - 1;
					}
				}
				answer += index;
			}

			System.out.println(answer);
		}
	}
}
