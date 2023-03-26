package baek.silver;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class B1303_전쟁전투 {

	static int N, M, count = 0;
	static int white_count = 0;
	static int black_count = 0;

	static int dr[] = {-1, 1, 0, 0};
	static int dc[] = {0, 0, -1, 1};
	static boolean Visited[][];
	static char map[][];

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		N = scan.nextInt();
		M = scan.nextInt();

		Visited = new boolean[M][N];
		map = new char[M][N];

		for (int i = 0; i < M; i++) {
			String str = scan.next();

			for (int j = 0; j < N; j++) {
				char ch = str.charAt(j);
				map[i][j] = ch;
			}
		}

		for (int i = 0; i < M; i++) {
			for (int j = 0; j < N; j++) {

				if (!Visited[i][j]) {
					bfs(i, j, map[i][j]);

					if (map[i][j] == 'W') {
						white_count += count * count;
					} else {
						black_count += count * count;
					}

				}
			}
		}

		System.out.println(white_count + " " + black_count);
	}

	public static void bfs(int r, int c, char ch) {
		Queue<Point> que = new LinkedList<>();
		que.offer(new Point(r, c));
		Visited[r][c] = true;
		count = 1;

		while (!que.isEmpty()) {
			Point cur = que.poll();

			for (int i = 0; i < 4; i++) {
				int nr = cur.r + dr[i];
				int nc = cur.c + dc[i];

				if (nr >= 0 && nr < M && nc >= 0 && nc < N && !Visited[nr][nc]
					&& ch == map[nr][nc]) {
					Visited[nr][nc] = true;
					count++;
					que.offer(new Point(nr, nc));
				}

			}
		}
	}

	static class Point {

		int r, c;

		Point(int r, int c) {
			this.r = r;
			this.c = c;
		}
	}
}

