package baek;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class B17144_미세먼지안녕 {
	static int R, C, T, res = 0;
	static int[][] map;
	static int[] air = new int[2];
	static int[] dr = { 1, -1, 0, 0 };
	static int[] dc = { 0, 0, 1, -1 };

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
		R = sc.nextInt();
		C = sc.nextInt();
		T = sc.nextInt();

		map = new int[R][C];
		int idx = 0;

		for (int r = 0; r < R; r++) {
			for (int c = 0; c < C; c++) {
				map[r][c] = sc.nextInt();
				if (map[r][c] == -1) {
					air[idx] = r;
					idx++;
				}
			}
		}

		for (int time = 0; time < T; time++) {
			spread();
			circulate();
		}

		for (int r = 0; r < R; r++) {
			for (int c = 0; c < C; c++) {
				if (map[r][c] != -1) {
					res += map[r][c];
				}
			}
		}
		System.out.println(res);
	}

	private static void spread() {
		// TODO Auto-generated method stub
		Queue<Point> dust = new LinkedList<>();
		int[][] temp = new int[R][C];

		for (int r = 0; r < R; r++) {
			for (int c = 0; c < C; c++) {
				if (map[r][c] > 4) { // 4 이하로는 미세먼지가 확산되지 않기 떄문에..
					dust.add(new Point(r, c));
				}
			}
		}

		while (!dust.isEmpty()) {
			Point p = dust.poll();
			int cnt = 0;
			for (int k = 0; k < 4; k++) {
				int nr = p.r + dr[k];
				int nc = p.c + dc[k];
				if (nr >= 0 && nr < R && nc >= 0 && nc < C && map[nr][nc] != -1) {
					cnt++;
					temp[nr][nc] += map[p.r][p.c] / 5;
				}
			}
			map[p.r][p.c] -= (map[p.r][p.c] / 5) * cnt;
		}

		for (int r = 0; r < R; r++) {
			for (int c = 0; c < C; c++) {
				map[r][c] += temp[r][c];
			}
		}
	}

	private static void circulate() {
		// TODO Auto-generated method stub
		// 반시계 방향
		// 1.위에서 아래
		for (int i = air[0] - 1; i > 0; i--) {
			map[i][0] = map[i - 1][0];
		}
		// 2.오른쪽에서 왼쪽
		for (int i = 0; i < C - 1; i++) {
			map[0][i] = map[0][i + 1];
		}
		// 3.아래에서 위
		for (int i = 0; i < air[0]; i++) {
			map[i][C - 1] = map[i + 1][C - 1];
		}
		// 4.왼쪽에서 오른쪽
		for (int i = C - 1; i > 0; i--) {
			map[air[0]][i] = map[air[0]][i - 1];
			if (i == 1) {
				map[air[0]][i] = 0;
			}
		}

		// 시계 방향
		// 1.아래에서 위
		for (int i = air[1] + 1; i < R - 1; i++) {
			map[i][0] = map[i + 1][0];
		}
		// 2.오른쪽에서 왼족
		for (int i = 0; i < C - 1; i++) {
			map[R - 1][i] = map[R - 1][i + 1];
		}
		// 3.위에서 아래
		for (int i = R - 1; i > air[1]; i--) {
			map[i][C - 1] = map[i - 1][C - 1];
		}
		// 4.왼쪽에서 오른쪽
		for (int i = C - 1; i > 0; i--) {
			map[air[1]][i] = map[air[1]][i - 1];
			if (i == 1) {
				map[air[1]][i] = 0;
			}
		}
	}
}
