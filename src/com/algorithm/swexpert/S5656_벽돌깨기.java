package com.algorithm.swexpert;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

/*
 * 다시 풀어보기
 */

/*
 * 1. N번 떨어트릴 때 
 */
public class S5656_벽돌깨기 {

	static int N, W, H, RES;
	static int[] select;
	static int[][] map;
	static boolean[][] visit;
	static int[] dr = { -1, 1, 0, 0 };
	static int[] dc = { 0, 0, -1, 1 };

	static class Brick {
		int r, c, range;

		public Brick(int r, int c, int range) {
			super();
			this.r = r;
			this.c = c;
			this.range = range;
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();

		for (int tc = 1; tc <= T; tc++) {
			N = sc.nextInt();
			W = sc.nextInt();
			H = sc.nextInt();

			select = new int[N];
			map = new int[H][W];
			RES = Integer.MAX_VALUE;

			for (int i = 0; i < H; i++) {
				for (int j = 0; j < W; j++) {
					map[i][j] = sc.nextInt();
				}
			}
			solve(0);
			System.out.println("#" + tc + " " + RES);
		}
	}

	private static void solve(int cnt) {
		if (cnt == N) { 
			int[][] copy = copyMap();
			int brick = 0;

			for (int i = 0; i < N; i++) {
				visit = new boolean[H][W];
				brick(copy, select[i]); // 벽돌 선택하고 깨기
				drop(copy); // 벽돌 떨어트리기
			}
			
			// 남아있는 벽돌의 개수 구하기 
			for (int h = 0; h < H; h++) {
				for (int w = 0; w < W; w++) {
					if (copy[h][w] > 0)
						brick++;
				}
			}
			
			// 남아있는 벽돌의 개수 최소값으로 갱신
			RES = Math.min(RES, brick); 
			// RES = RES > brick ? brick : RES;
			return;
		}

		// 열에 대한 모든 경우의 수 구하기
		for (int w = 0; w < W; w++) { 
			select[cnt] = w;
			solve(cnt + 1);
		}
	}

	/*************************************/
	private static void drop(int[][] copy) {
		Queue<Integer> tmp;

		for (int w = 0; w < W; w++) {
			tmp = new LinkedList<>();

			for (int h = H - 1; h >= 0; h--) {
				if (copy[h][w] > 0)
					tmp.add(copy[h][w]);
			}

			for (int h = H - 1; h >= 0; h--) {
				if (!tmp.isEmpty()) {
					copy[h][w] = tmp.poll();
				} else {
					copy[h][w] = 0;
				}
			}
		}
	}

	private static void brick(int[][] copy, int idx) {
		Queue<Brick> queue = new LinkedList<>();

		for (int h = 0; h < H; h++) {
			if (copy[h][idx] > 0) {
				queue.add(new Brick(h, idx, copy[h][idx]));
				break;
			}
		}

		while (!queue.isEmpty()) {
			Brick cur = queue.poll();

			for (int d = 0; d < 4; d++) {
				for (int r = 0; r < cur.range; r++) {
					int nr = cur.r + dr[d] * r;
					int nc = cur.c + dc[d] * r;

					if (nr >= 0 && nc >= 0 && nr < H && nc < W && !visit[nr][nc]) {
						visit[nr][nc] = true;
						queue.add(new Brick(nr, nc, copy[nr][nc]));
						copy[nr][nc] = 0;
					}
				}
			}
		}
	}

	private static int[][] copyMap() {

		int[][] tmp = new int[H][W];

		for (int h = 0; h < H; ++h) {
			for (int w = 0; w < W; ++w) {
				tmp[h][w] = map[h][w];
			}
		}
		return tmp;
	}

}
