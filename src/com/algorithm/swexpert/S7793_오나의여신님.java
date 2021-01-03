package com.algorithm.swexpert;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class S7793_오나의여신님 {
	static int N, M;
	static char[][] map;
	static int[][] time;
	static Queue<Point> Q;
	static int[] dr = { 1, -1, 0, 0 };
	static int[] dc = { 0, 0, -1, 1 };

	static class Point {
		int r, c;
		char state;

		public Point(int r, int c, char state) {
			super();
			this.r = r;
			this.c = c;
			this.state = state;
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();

		for (int tc = 1; tc <= T; tc++) {
			N = sc.nextInt();
			M = sc.nextInt();
			map = new char[N][M];
			time = new int[N][M];
			Q = new LinkedList<>();

			int end_r = 0, end_c = 0;
			for (int r = 0; r < N; r++) {
				String str = sc.next();
				for (int c = 0; c < M; c++) {
					map[r][c] = str.charAt(c);
					
					if (map[r][c] == '*') {
						Q.add(new Point(r, c, '*'));
					}else if (map[r][c] == 'D') {
						end_r = r;
						end_c = c;
					}
				}
			}
			bfs();

			if (time[end_r][end_c] != 0) {
				System.out.println("#" + tc + " " + time[end_r][end_c]);
			} else {
				System.out.println("#" + tc + " GAME OVER");
			}
		}
	}

	private static void bfs() {
		// TODO Auto-generated method stub
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if (map[i][j] == 'S')
					Q.add(new Point(i, j, 'S'));
			}
		}

		while (!Q.isEmpty()) {
			Point p = Q.poll();

			for (int k = 0; k < 4; k++) {
				int nr = p.r + dr[k];
				int nc = p.c + dc[k];

				if (nr >= 0 && nr < N && nc >= 0 && nc < M) {
					if (p.state == '*') {
						if (map[nr][nc] == '.' || map[nr][nc] == 'S') {
							map[nr][nc] = '*';
							Q.add(new Point(nr, nc, p.state));
						}
					}

					if (p.state == 'S') {
						if (map[nr][nc] == '.') {
							time[nr][nc] = time[p.r][p.c] + 1;
							map[nr][nc] = 'S';
							Q.add(new Point(nr, nc, p.state));
						} else if (map[nr][nc] == 'D') {
							time[nr][nc] = time[p.r][p.c] + 1;
							return;
						}
					}
				}

			}
		}
	}
}
