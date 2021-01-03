package com.algorithm.jongol;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class J1106_장기 {
	static int N, M, R, C, s, k, ans = Integer.MAX_VALUE;
	static boolean[][] visit;
	static int[] dr = {-1, 1, -1, 1, -2, -2, 2, 2};
	static int[] dc = {-2, -2, 2, 2, -1, 1, -1, 1};
	static class Point{
		int r, c, cnt;

		public Point(int r, int c, int cnt) {
			super();
			this.r = r;
			this.c = c;
			this.cnt = cnt;
		}
		
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		M = sc.nextInt();
		visit = new boolean[N][M];
		
		R = sc.nextInt();
		C = sc.nextInt();

		s = sc.nextInt();
		k = sc.nextInt();
		
		bfs();
		System.out.println(ans);
	}

	private static void bfs() {
		Queue<Point> queue = new LinkedList<>();
		queue.add(new Point(R, C, 0));
		visit[R][C] = true;
		
		while(!queue.isEmpty()) {
			Point p = queue.poll();
			if(p.r == s && p.c == k) {
				ans = p.cnt;
				return;
			}
			for(int i = 0; i < 8; i++) {
				int nr = p.r + dr[i];
				int nc = p.c + dc[i];
				
				if(nr < 0 || nr >= N || nc < 0 || nc >= M || visit[nr][nc]) continue;
				
				queue.add(new Point(nr, nc, p.cnt + 1));
				visit[nr][nc] = true;
			}
		}
	}
}
