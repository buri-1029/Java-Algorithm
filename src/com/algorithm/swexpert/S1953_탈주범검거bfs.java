package com.algorithm.swexpert;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class S1953_탈주범검거bfs {
	static int N, M, R, C, L, RES;
	static int[][] map;
	static boolean[][] visit;
	static int[] dr = { -1, 1, 0, 0 };
	static int[] dc = { 0, 0, -1, 1 };

	static class Tunnel {
		int r, c;

		public Tunnel(int r, int c) {
			super();
			this.r = r;
			this.c = c;
		}

	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();

		for (int tc = 1; tc <= T; tc++) {
			N = sc.nextInt();
			M = sc.nextInt();
			map = new int[N][M];
			visit = new boolean[N][M];

			R = sc.nextInt();
			C = sc.nextInt();
			L = sc.nextInt();
			
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < M; j++) {
					map[i][j] = sc.nextInt();
				}
			}

			RES = 1;
			bfs();
			System.out.println("#" + tc + " " + RES);
		}
	}

	private static void bfs() {
		Queue<Tunnel> queue = new LinkedList<>();
		queue.add(new Tunnel(R, C));
		visit[R][C] = true;
		int time = 1;

		while (!queue.isEmpty()) {
			int size = queue.size();
			if (time == L) return;

			for (int i = 0; i < size; i++) {
				Tunnel cur = queue.poll();
				int type = map[cur.r][cur.c];

				for (int d = 0; d < 4; d++) {
					int nr = cur.r + dr[d];
					int nc = cur.c + dc[d];

					if (nr < 0 || nc < 0 || nr >= N || nc >= M) continue;
					if (visit[nr][nc] || map[nr][nc] == 0) continue;

					int next = map[nr][nc];

					switch (d) {
					case 0:
						if (type == 1 || type == 2 || type == 4 || type == 7) {
							if (next == 1 || next == 2 || next == 5 || next == 6) {
								visit[nr][nc] = true;
								queue.offer(new Tunnel(nr, nc));
								RES++;
							}
						}
						break;
					case 1:
						if (type == 1 || type == 2 || type == 5 || type == 6) {
							if (next == 1 || next == 2 || next == 4 || next == 7) {
								visit[nr][nc] = true;
								queue.offer(new Tunnel(nr, nc));
								RES++;
							}
						}
						break;
					case 2:
						if (type == 1 || type == 3 || type == 6 || type == 7) {
							if (next == 1 || next == 3 || next == 4 || next == 5) {
								visit[nr][nc] = true;
								queue.offer(new Tunnel(nr, nc));
								RES++;
							}
						}
						break;
					case 3:
						if (type == 1 || type == 3 || type == 4 || type == 5) {
							if (next == 1 || next == 3 || next == 6 || next == 7) {
								visit[nr][nc] = true;
								queue.offer(new Tunnel(nr, nc));
								RES++;
							}
						}
						break;
					}
				}
			}
			time++;
		}
	}
}
