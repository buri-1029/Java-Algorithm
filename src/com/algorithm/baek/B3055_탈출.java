package com.algorithm.baek;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class B3055_탈출 {
	static int R, C, dx, dy;
	static char[][] map;
	static int[][] time;
	static Queue<Point> q = new LinkedList<>();

	static int[] dr = { 1, -1, 0, 0 };
	static int[] dc = { 0, 0, 1, -1 };

	static class Point {
		int r, c;
		char state; // *:물 인지, S:고슴도치 위치 인지

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
		R = sc.nextInt();
		C = sc.nextInt();
		map = new char[R][C];
		time = new int[R][C];

		for (int r = 0; r < R; r++) {
			String str = sc.next();
			for (int c = 0; c < C; c++) {
				map[r][c] = str.charAt(c);

				if (map[r][c] == 'D') { // 소굴 위치 저장
					dx = r;
					dy = c;
				}
			}
		}

		bfs();

		if (time[dx][dy] != 0) {
			System.out.println(time[dx][dy]);
		} else {
			System.out.println("KAKTUS");
		}
	}

	private static void bfs() {
		// TODO Auto-generated method stub
		Queue<Point> q = new LinkedList<>();
		for (int r = 0; r < R; r++) {
			for (int c = 0; c < C; c++) {
				if (map[r][c] == '*') // 물이 차오르는 위치부터 큐에 추가
					q.add(new Point(r, c, '*'));
			}
		}

		for (int r = 0; r < R; r++) {
			for (int c = 0; c < C; c++) {
				if (map[r][c] == 'S') // 그 다음 고슴도치의 시작 위치 큐에 추가
					q.add(new Point(r, c, 'S'));
			}
		}

		while (!q.isEmpty()) {
			Point p = q.poll();

			for (int k = 0; k < 4; k++) {
				int nr = p.r + dr[k];
				int nc = p.c + dc[k];

				// 큐에서 '물과 고슴도치'의 위치를 번갈아가며 상하좌우로 이동,
				if (nr >= 0 && nr < R && nc >= 0 && nc < C) {
					if (p.state == '*') {
						if (map[nr][nc] == '.' || map[nr][nc] == 'S') {
							map[nr][nc] = '*';
							q.add(new Point(nr, nc, p.state));
						}
					}

					if (p.state == 'S') {
						if (map[nr][nc] == '.') {	 	 // 고슴도치는 이동하면서 time[][]에 이동시간 저장
							time[nr][nc] = time[p.r][p.c] + 1; 
							map[nr][nc] = 'S';
							q.add(new Point(nr, nc, p.state));
						} else if (map[nr][nc] == 'D') { // 두더지 소굴 만나면 time[][]에 이동시간 저장하고 return;
							time[nr][nc] = time[p.r][p.c] + 1;
							return;
						}
					}
				}
			}
		}
	}
}
