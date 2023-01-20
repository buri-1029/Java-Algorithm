package baek.silver;

import java.util.Scanner;

public class B1051_숫자정사각형 {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int N = scan.nextInt();
		int M = scan.nextInt();

		int[][] arr = new int[N][M];
		int max = Math.min(N, M);

		for (int i = 0; i < N; i++) {
			String str = scan.next();

			for (int j = 0; j < M; j++) {
				arr[i][j] = str.charAt(j) - '0';
			}
		}

		while (max > 1) {
			for (int i = 0; i <= N - max; i++) {
				for (int j = 0; j <= M - max; j++) {
					int num = arr[i][j];

					if (num == arr[i][j + max - 1] &&
						num == arr[i + max - 1][j] &&
						num == arr[i + max - 1][j + max - 1]) {

						System.out.println(max * max);
						return;
					}
				}
			}

			max--;
		}

		System.out.println(max * max);
	}
}
