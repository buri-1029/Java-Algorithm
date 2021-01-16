package baek;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class B4485_녹색옷입은애가젤다지 {
	static int N, res;
	static int[][] map;
	static int[][] visit;
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

		int num = 0;
		while (true) {
			N = sc.nextInt();
			if (N == 0) break;
			
			map = new int[N][N];
			visit = new int[N][N];

			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					map[i][j] = sc.nextInt();
					visit[i][j] = 987654321;
				}
			}
			num++;
			bfs();
			System.out.println("Problem " + num + ": " + res);
		}
	}

	private static void bfs() {
		Queue<Point> queue = new LinkedList<>();
		queue.add(new Point(0, 0));
		visit[0][0] = map[0][0];

		while (!queue.isEmpty()) {
			Point p = queue.poll();
			
			if(p.r == N - 1 && p.c == N - 1) {
				res = visit[N - 1][N - 1];
			}
			for (int d = 0; d < 4; d++) {
				int nr = p.r + dr[d];
				int nc = p.c + dc[d];

				if (nr < 0 || nc < 0 || nr >= N || nc >= N ) continue;

				// 방문체크, 로직구현,필요하면 큐에 삽입
				if (visit[nr][nc] > map[nr][nc] + visit[p.r][p.c]) {
					visit[nr][nc] = map[nr][nc] + visit[p.r][p.c];
					queue.add(new Point(nr, nc));
				}
			}
		}
	}
}
