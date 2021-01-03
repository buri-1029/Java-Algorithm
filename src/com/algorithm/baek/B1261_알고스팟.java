package com.algorithm.baek;

import java.util.PriorityQueue;
import java.util.Scanner;
/*
 *  bfs + 우선순위 큐 사용
 * 
 *	다익스트라로 풀어보기!
 */
public class B1261_알고스팟 {
	static int N, M, Ans = 0;
	static int[][] map;
	static boolean[][] visit;
	static int[] dr = { 1, 0, -1, 0 };
	static int[] dc = { 0, 1, 0, -1 };

	static class Point implements Comparable<Point>{
		int r, c, cnt;

		public Point(int r, int c, int cnt) {
			super();
			this.r = r;
			this.c = c;
			this.cnt = cnt;
		}

		@Override
		public int compareTo(Point o) {		
			return this.cnt - o.cnt;
		}
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		M = sc.nextInt(); // 가로 크기
		N = sc.nextInt(); // 세로 크기
		map = new int[N][M];
		visit = new boolean[N][M];

		for (int i = 0; i < N; i++) {
			String str = sc.next();
			for (int j = 0; j < M; j++) {
				map[i][j] = str.charAt(j) - '0';
			}
		}

		bfs();
		System.out.println(Ans);
	}

	private static void bfs() {
		PriorityQueue<Point> queue = new PriorityQueue<>();
		queue.add(new Point(0, 0, 0));
		visit[0][0] = true;

		while (!queue.isEmpty()) {
			Point p = queue.poll();
			
			if(p.r == N - 1 && p.c == M - 1){
				Ans = p.cnt;
				break;
			}
			
			for (int d = 0; d < 4; d++) {
				int nr = p.r + dr[d];
				int nc = p.c + dc[d];

				if (nr < 0 || nc < 0 || nr >= N || nc >= M || visit[nr][nc]) continue;

				if (map[nr][nc] == 0) queue.add(new Point(nr, nc, p.cnt));
				else if (map[nr][nc] == 1) queue.add(new Point(nr, nc, p.cnt + 1));		
				visit[nr][nc] = true;
			}
		}
	}
}
