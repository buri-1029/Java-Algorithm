package baek.gold;

import java.util.Scanner;

public class B14503_로봇청소기 {

	public static int N, M;
	public static int[][] map;
	public static int answer = 0;
	public static int[] dr = {-1, 0, 1, 0};
	public static int[] dc = {0, 1, 0, -1};

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);

		N = scan.nextInt();
		M = scan.nextInt();
		map = new int[N][M];

		int r = scan.nextInt();
		int c = scan.nextInt();
		int d = scan.nextInt();

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				map[i][j] = scan.nextInt();
			}
		}

		dfs(r, c, d);
		System.out.println(answer);
	}

	private static void dfs(int r, int c, int d) {
		if (map[r][c] == 0) {
			map[r][c] = 2;
			answer++;
		}

		boolean flag = false;
		int tmp = d;

		for (int i = 0; i < 4; i++) {
			int nd = (d + 3) % 4;
			int nr = r + dr[nd];
			int nc = c + dc[nd];

			if (nr > 0 && nr < N && nc > 0 && nc < M && map[nr][nc] == 0) {
				dfs(nr, nc, nd);
				flag = true;
				break;
			}

			d = (d + 3) % 4;
		}

		if (!flag) {
			int nd = (tmp + 2) % 4;
			int nr = r + dr[nd];
			int nc = c + dc[nd];

			if (nr > 0 && nr < N && nc > 0 && nc < M && map[nr][nc] != 1) {
				dfs(nr, nc, tmp);
			}
		}
	}

}
