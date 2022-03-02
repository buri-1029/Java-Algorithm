package baek.silver;

import java.util.Scanner;

public class B14716_현수막 {

	static int M, N, Ans = 0;
	static int[][] arr;
	static boolean[][] visit;
	static int[] dr = {-1, 1, 0, 0, -1, -1, 1, 1};
	static int[] dc = {0, 0, -1, 1, -1, 1, -1, 1};

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		M = sc.nextInt();
		N = sc.nextInt();
		arr = new int[M][N];
		visit = new boolean[M][N];

		for (int i = 0; i < M; i++) {
			for (int j = 0; j < N; j++) {
				arr[i][j] = sc.nextInt();
			}
		}
		for (int i = 0; i < M; i++) {
			for (int j = 0; j < N; j++) {
				if (arr[i][j] == 1 && !visit[i][j]) {
					dfs(i, j);
					Ans++;
				}
			}
		}
		System.out.println(Ans);

	}

	private static void dfs(int r, int c) {
		for (int d = 0; d < 8; d++) {
			int nr = r + dr[d];
			int nc = c + dc[d];

			if (nr < 0 || nc < 0 || nr >= M || nc >= N
				|| visit[nr][nc] || arr[nr][nc] == 0) {
				continue;
			}

			visit[nr][nc] = true;
			dfs(nr, nc);
		}
	}
}
