package com.algorithm.swexpert;

import java.io.IOException;
import java.util.PriorityQueue;
import java.util.Scanner;

public class S1249_보급로 {
	static int N, TIME;
	static int[][] map;
	static boolean[][] visit;
	static int[] dr = { 0, 1, -1, 0 };
	static int[] dc = { 1, 0, 0, -1 };

	static class Point implements Comparable<Point>{
		int r, c;
		int t;

		public Point(int r, int c, int t) {
			super();
			this.r = r;
			this.c = c;
			this.t = t;
		}

		@Override
		public int compareTo(Point o) {
			return this.t - o.t;
		}
	}

	public static void main(String[] args) throws NumberFormatException, IOException {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();

		for (int tc = 1; tc <= T; tc++) {
			N = sc.nextInt();
			map = new int[N][N];
			visit = new boolean[N][N];
			TIME = 0;

			for (int i = 0; i < N; i++) {
				String str = sc.next();
				for (int j = 0; j < N; j++) {
					map[i][j] = str.charAt(j) - '0';
				}
			}
			bfs();
			System.out.println("#" + tc + " " + TIME);
		}
	}

	private static void bfs() {
		PriorityQueue<Point> pq = new PriorityQueue<>();
		pq.add(new Point(0, 0, 0));
		visit[0][0] = true;

		while (!pq.isEmpty()) {
			Point p = pq.poll();

			if (p.r == N - 1 && p.c == N - 1) {
				TIME = p.t;
				break;
			}

			for (int d = 0; d < 4; d++) {
				int nr = p.r + dr[d];
				int nc = p.c + dc[d];

				if (nr >= 0 && nr < N && nc >= 0 && nc < N && !visit[nr][nc]) {		
					pq.add(new Point(nr,nc,p.t + map[nr][nc]));
					visit[nr][nc] = true;
				}
			}
		}
	}
}
