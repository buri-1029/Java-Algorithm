package baek.silver;

import java.util.Scanner;

public class B2167_2차원배열의합 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int M = sc.nextInt();

		int[][] arr = new int[N][M];

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				arr[i][j] = sc.nextInt();
			}
		}

		int K = sc.nextInt();

		for (int k = 0; k < K; k++) {
			int i = sc.nextInt();
			int j = sc.nextInt();

			int x = sc.nextInt();
			int y = sc.nextInt();

			int tmp = 0;

			for (int a = i - 1; a < x; a++) {
				for (int b = j - 1; b < y; b++) {
					tmp += arr[a][b];
				}
			}

			System.out.println(tmp);
		}
	}
}
