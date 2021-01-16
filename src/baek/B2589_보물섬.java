package baek;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class B2589_보물섬 {
	static int R, C, dist, Res = 0;
	static char[][] map;
	static boolean[][] visit;
	static int[] dr = { -1, 1, 0, 0 };
	static int[] dc = { 0, 0, -1, 1 };

	static class Point {
		int r, c, cnt; // cnt : 이동한 거리 수

		public Point(int r, int c, int cnt) {
			super();
			this.r = r;
			this.c = c;
			this.cnt = cnt;
		}
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		R = sc.nextInt(); // 세로 크기
		C = sc.nextInt(); // 가로 크기
		map = new char[R][C];

		for (int i = 0; i < R; i++) {
			String str = sc.next();
			for (int j = 0; j < C; j++) {
				map[i][j] = str.charAt(j);
			}
		} // 입력

		for (int i = 0; i < R; i++) {
			for (int j = 0; j < C; j++) {
				if (map[i][j] == 'L') {  
					visit = new boolean[R][C];
					dist = 0;
					bfs(i, j);
					Res = Math.max(Res, dist);
				}
			}
		}
		System.out.println(Res);
	}

	private static void bfs(int r, int c) {
		Queue<Point> queue = new LinkedList<>();
		queue.add(new Point(r, c, 0));
		visit[r][c] = true;

		while (!queue.isEmpty()) {
			Point p = queue.poll();

			for (int d = 0; d < 4; d++) {
				int nr = p.r + dr[d];
				int nc = p.c + dc[d];

				if (nr < 0 || nc < 0 || nr >= R || nc >= C 
						|| map[nr][nc] == 'W' || visit[nr][nc]) continue;

				visit[nr][nc] = true;
				queue.add(new Point(nr, nc, p.cnt + 1));
				dist = Math.max(dist, p.cnt + 1); // 시작점으로부터 가장 먼 거리에 있는 값 선택
			}
		}
	}
}
