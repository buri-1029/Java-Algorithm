package baek.silver;

import java.util.Scanner;

public class B3187_양치기꿍 {

	static int R, C, vcnt, kcnt, vAns = 0, kAns = 0;
	static char[][] map;
	static boolean[][] visit;
	static int[] dr = {-1, 1, 0, 0};
	static int[] dc = {0, 0, -1, 1};

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		R = sc.nextInt();
		C = sc.nextInt();
		map = new char[R][C];
		visit = new boolean[R][C];

		for (int i = 0; i < R; i++) {
			String str = sc.next();
			for (int j = 0; j < C; j++) {
				map[i][j] = str.charAt(j);
			}
		}

		for (int i = 0; i < R; i++) {
			for (int j = 0; j < C; j++) {
				if (map[i][j] != '#' && !visit[i][j]) {
					vcnt = 0;
					kcnt = 0;
					dfs(i, j);
					if (kcnt > vcnt) {
						vcnt = 0;
					} else {
						kcnt = 0;
					}
					vAns += vcnt;
					kAns += kcnt;
				}
			}
		}
		System.out.println(kAns + " " + vAns);
	}

	private static void dfs(int r, int c) {
		visit[r][c] = true;
		if (map[r][c] == 'k') {
			kcnt++;
		} else if (map[r][c] == 'v') {
			vcnt++;
		}

		for (int d = 0; d < 4; d++) {
			int nr = r + dr[d];
			int nc = c + dc[d];

			if (nr < 0 || nc < 0 || nr >= R || nc >= C
				|| visit[nr][nc] || map[nr][nc] == '#') {
				continue;
			}

			visit[nr][nc] = true;
			dfs(nr, nc);
		}
	}
}
