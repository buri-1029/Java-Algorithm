package baek.gold;

import java.util.Scanner;

public class B2458_키순서 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int M = sc.nextInt();

		int[][] arr = new int[N][N];

		for (int i = 0; i < M; i++) {
			int a = sc.nextInt() - 1;
			int b = sc.nextInt() - 1;

			arr[a][b] = -1;
			arr[b][a] = 1;
		}

		for (int k = 0; k < N; k++) {
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					if (arr[i][k] == 1 && arr[k][j] == 1) {
						arr[i][j] = 1;
					}

					if (arr[i][k] == -1 && arr[k][j] == -1) {
						arr[i][j] = -1;
					}
				}
			}
		}

		int answer = 0;

		for (int i = 0; i < N; i++) {
			int cnt = 0;

			for (int j = 0; j < N; j++) {
				if (arr[i][j] == 0) {
					cnt++;
				}
			}

			if (cnt == 1) {
				answer++;
			}
		}

		System.out.println(answer);
	}
}
