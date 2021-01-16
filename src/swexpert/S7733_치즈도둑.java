package swexpert;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class S7733_치즈도둑 {
	static int[] dr = { 1, -1, 0, 0 };
	static int[] dc = { 0, 0, 1, -1 };
	static int[][] map;
	static boolean[][] v;
	static int T, N, Ans, lump;
	static class Point {
		int r, c;

		Point(int r, int c) {
			this.r = r;
			this.c = c;
		}
	}
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		T = sc.nextInt();

		for (int tc = 1; tc <= T; tc++) {
			Ans = 0;
			N = sc.nextInt();
			map = new int[N][N];
			v = new boolean[N][N];

			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					map[i][j] = sc.nextInt();
				}
			}

			for (int day = 1; day <= 100; day++) {
				lump = 0; // 덩어리
				v = new boolean[N][N];
				for (int r = 0; r < N; r++) {
					for (int c = 0; c < N; c++) {
						if (map[r][c] <= day) {
							v[r][c] = true;
						}
					}
				}
				for (int r = 0; r < N; r++) {
					for (int c = 0; c < N; c++) {
						if (!v[r][c]) {
							bfs(r, c, day);
						}
					}
				}
				if(lump == 0) lump = 1;
				Ans = Math.max(Ans, lump);
			}
			System.out.print("#"+tc+" "+Ans);
		}
	}

	private static void bfs(int r, int c, int day) {
		Queue<Point> Q = new LinkedList();
		Q.add(new Point(r, c));		
		while (!Q.isEmpty()) {
			Point p = Q.poll();
			v[p.r][p.c] = true;
			for (int k = 0; k < 4; k++) {
				int nr = p.r + dr[k];
				int nc = p.c + dc[k];

				if (nr >= 0 && nr < N && nc >= 0 && nc < N) {
					if (map[nr][nc] > day && !v[nr][nc]) {
						v[nr][nc] = true;
						Q.add(new Point(nr, nc));
					}
				}
			}
		}
		lump++;
	}
}