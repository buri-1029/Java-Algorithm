package com.algorithm.baek;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class B2206_벽부수고이동하기 {
	static int[][] map;
	static boolean[][][] visit;
	static int N, M, Ans = Integer.MAX_VALUE;
	static int[] dr = { 0, 0, 1, -1 };
	static int[] dc = { 1, -1, 0, 0 };

	static class Point {	// cnt : 이동 거리
		int r, c, cnt, puk; // puk -> 0 : 안부순거 / 1 : 부순거

		Point(int r, int c, int cnt, int puk) {
			this.r = r;
			this.c = c;
			this.cnt = cnt;
			this.puk = puk;
		}
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		N = sc.nextInt();
		M = sc.nextInt();

		map = new int[N + 1][M + 1];
		visit = new boolean[N + 1][M + 1][2];
		// visit[r][c][0] -> 벽을 부수고 이동하였는지
		// visit[r][c][1] -> 벽을 부수지 않고 이동하였는지

		for (int r = 1; r <= N; r++) {
			String str = sc.next();
			for (int c = 1; c <= M; c++) {
				map[r][c] = str.charAt(c - 1) - '0';
			}
		}
		bfs();
		System.out.println(Ans == Integer.MAX_VALUE ? -1 : Ans);
	}

	private static void bfs() {
		// Q에다 하나 저장하고 (하나 빼면서 그애와 관련된 애들 Q에가 넣는다) 반복
		Queue<Point> Q = new LinkedList<Point>();
		Q.add(new Point(1, 1, 1, 0));
		visit[1][1][0] = true;
		while (!Q.isEmpty()) {
			Point p = Q.poll();
			if (p.r == N && p.c == M) { 	// 도착점이면
				Ans = Math.min(Ans, p.cnt);	// 이동거리 중 작은 값
				break;
			}
			for (int k = 0; k < 4; k++) {
				int nr = p.r + dr[k];
				int nc = p.c + dc[k];
				int npuk = p.puk;
				// 지도 안에 있고
				if (nr > 0 && nr <= N && nc > 0 && nc <= M) {
					if (map[nr][nc] == 0 && !visit[nr][nc][npuk]) {
						visit[nr][nc][npuk] = true;
						Q.add(new Point(nr, nc, p.cnt + 1, p.puk));
					}

					else if (map[nr][nc] == 1 && npuk == 0) {
						visit[nr][nc][1] = true;
						Q.add(new Point(nr, nc, p.cnt + 1, 1));
					}
				}
			}
		}
	}
}