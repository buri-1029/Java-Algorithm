package baek.silver;

import java.util.Scanner;

public class B1018_체스판다시칠하기 {

	public static boolean[][] arr;
	public static int answer = 64;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int M = sc.nextInt();

		boolean[][] arr = new boolean[N][M];

		for (int i = 0; i < N; i++) {
			String str = sc.next();

			for (int j = 0; j < M; j++) {
				arr[i][j] = str.charAt(j) == 'W';

			}
		}

		int n = N - 7;
		int m = M - 7;

		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				check(arr, i, j);
			}
		}

		System.out.println(answer);
	}

	private static void check(boolean[][] arr, int x, int y) {
		int end_x = x + 8;
		int end_y = y + 8;
		int count = 0;

		boolean chess = arr[x][y];

		for (int i = x; i < end_x; i++) {
			for (int j = y; j < end_y; j++) {

				if (arr[i][j] != chess) {
					count++;
				}

				chess = (!chess);
			}

			chess = !chess;
		}

		count = Math.min(count, 64 - count);
		answer = Math.min(answer, count);
	}
}
