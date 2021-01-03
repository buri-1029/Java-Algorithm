package com.algorithm.baek;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class B2234_성곽 {
	static int n, m, cnt = 0, base_big = Integer.MIN_VALUE;
	static int wall_big = Integer.MIN_VALUE;
	static int[][] map;
	static boolean[][] visit;
	static int[] dr = { 0, -1, 0, 1 };
	static int[] dc = { -1, 0, 1, 0 };

	static class Point {
		int r, c;

		public Point(int r, int c) {
			super();
			this.r = r;
			this.c = c;
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		m = sc.nextInt();

		map = new int[m][n];
		visit = new boolean[m][n];

		for (int r = 0; r < m; r++) {
			for (int c = 0; c < n; c++) {
				map[r][c] = sc.nextInt();
			}
		}

		for (int r = 0; r < m; r++) {
			for (int c = 0; c < n; c++) {
				if (!visit[r][c]) {
					bfs1(r, c);
					cnt++;
				}
			}
		}
		for (int r = 0; r < m; r++) {
			for (int c = 0; c < n; c++) {
				bfs2(r, c);
			}
		}

		System.out.println(cnt);
		System.out.println(base_big);
	}
	
	private static void bfs1(int r, int c) {
		Queue<Point> q = new LinkedList<>();
		q.add(new Point(r, c));
		visit[r][c] = true;
		int room = 1;

		while (!q.isEmpty()) {
			Point p = q.poll();

			for (int k = 0; k < 4; k++) {
				int nr = p.r + dr[k];
				int nc = p.c + dc[k];

				if (nr >= 0 && nr < m && nc >= 0 && nc < n && !visit[nr][nc]) {
					if ((map[p.r][p.c] & (1 << k)) == 0) {
						room++;
						visit[nr][nc] = true;
						q.add(new Point(nr, nc));
					}
				}
			}
		}
		base_big = Math.max(base_big, room);
	}
	
	private static void bfs2(int r, int c) {
		// TODO Auto-generated method stub
		Queue<Point> q = new LinkedList<>();
		q.add(new Point(r, c));
		int room = 1;

		while (!q.isEmpty()) {
			Point p = q.poll();

			for (int k = 0; k < 4; k++) {
				int nr = p.r + dr[k];
				int nc = p.c + dc[k];

				if (nr >= 0 && nr < m && nc >= 0 && nc < n && !visit[nr][nc]) {
					if ((map[p.r][p.c] & (1 << k)) != 0) {
						
					}
				}
			}
		}
		wall_big = Math.max(wall_big, room);
	}
}
