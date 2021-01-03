package com.algorithm.baek;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class B7576_토마토 {
	static int M, N;
	static int[][] storage;
	static Queue<Point> tomato;
	static int[] dr = { 0, 0, -1, 1 };
	static int[] dc = { -1, 1, 0, 0 };

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
		M = sc.nextInt();
		N = sc.nextInt();
		storage = new int[N][M];
		tomato = new LinkedList<>();

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				storage[i][j] = sc.nextInt();
				if (storage[i][j] == 1) {
					tomato.add(new Point(i, j));
				}
			}
		}
		
		bfs();
		
		int res = 0;
		for(int i = 0; i < N; i++) {
			for(int j = 0; j < M; j++) {
				if(storage[i][j] == 0) {
					System.out.println(-1); return;
				}
				res = Math.max(res, storage[i][j]);
			}
		}
		System.out.println(res - 1);
	}

	private static void bfs() {

		while(!tomato.isEmpty()) {
			Point cur = tomato.poll();
			
			for(int d = 0; d < 4; d++) {
				int nr = cur.r + dr[d];
				int nc = cur.c + dc[d];
				
				if(nr < 0 || nc < 0 || nr >= N || nc >= M || 
						storage[nr][nc] != 0) continue;
				
				tomato.add(new Point(nr,nc));
				storage[nr][nc] = storage[cur.r][cur.c] + 1;
			}
		}
	}
}
