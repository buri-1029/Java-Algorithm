package baek.silver;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class B1743_음식물피하기 {

	static int n, m;
	static int[][] map;
	static boolean[][] visit;
	static int[] dr = {-1, 0, 1, 0};
	static int[] dc = {0, 1, 0, -1};

	public static void main(String[] args) {

		Scanner scan = new Scanner(System.in);
		n = scan.nextInt();
		m = scan.nextInt();
		int k = scan.nextInt();

		map = new int[n][m];
		visit = new boolean[n][m];
		int answer = 0;

		for (int i = 0; i < k; i++) {
			int r = scan.nextInt();
			int c = scan.nextInt();
			map[r - 1][c - 1] = 1;
		}

		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				if (!visit[i][j] && map[i][j] == 1) {
					answer = Math.max(answer, bfs(i, j));
				}
			}
		}

		System.out.println(answer);
	}

	public static int bfs(int r, int c) {
		int answer = 1;
		Queue<Point> queue = new LinkedList<>();
		queue.add(new Point(r, c));
		visit[r][c] = true;

		while (!queue.isEmpty()) {
			Point p = queue.poll();

			for (int i = 0; i < 4; i++) {
				int nr = p.r + dr[i];
				int nc = p.c + dc[i];

				if (nr >= 0 && nr < n && nc >= 0 && nc < m) {
					if (!visit[nr][nc] && map[nr][nc] == 1) {
						queue.add(new Point(nr, nc));
						visit[nr][nc] = true;
						answer++;
					}
				}
			}
		}

		return answer;
	}

	public static class Point {

		int r;
		int c;

		public Point(int r, int c) {
			this.r = r;
			this.c = c;
		}
	}


}
