package baek;

import java.util.Scanner;

public class B4963_섬의개수 {
	static int w, h, ans;
	static int[][] map;
	static boolean[][] visit;
	static int[] dr = { -1, 1, 0, 0, -1, -1, 1, 1 };
	static int[] dc = { 0, 0, -1, 1, -1, 1, -1, 1 };

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		while (true) {
			w = sc.nextInt();
			h = sc.nextInt();
			ans = 0;
			
			if (w == 0 && h == 0) break;

			map = new int[h][w];
			visit = new boolean[h][w];

			for (int i = 0; i < h; i++) {
				for (int j = 0; j < w; j++) {
					map[i][j] = sc.nextInt();
				}
			}

			for (int i = 0; i < h; i++) {
				for (int j = 0; j < w; j++) {
					if (map[i][j] == 1) {
						dfs(i, j);
						ans++;
					}
				}
			}
			System.out.println(ans);
		}
	}

	private static void dfs(int r, int c) {
		for (int d = 0; d < 8; d++) {
			int nr = r + dr[d];
			int nc = c + dc[d];

			if (nr < 0 || nc < 0 || nr >= h || nc >= w || map[nr][nc] == 0) continue;
			
			map[nr][nc] = 0;
			dfs(nr, nc);
		}
	}
}