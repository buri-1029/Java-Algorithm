package baek.silver;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class B7562_나이트의이동 {

	static int N, sr, sc, er, ec, Ans;
	static int[][] board;
	static boolean[][] visit;
	static int[] dr = {-2, -1, -2, -1, 1, 2, 1, 2};
	static int[] dc = {-1, -2, 1, 2, -2, -1, 2, 1};

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scan = new Scanner(System.in);
		int T = scan.nextInt();

		for (int tc = 0; tc < T; tc++) {
			N = scan.nextInt();
			board = new int[N][N];
			visit = new boolean[N][N];

			sr = scan.nextInt();
			sc = scan.nextInt();

			er = scan.nextInt();
			ec = scan.nextInt();

			bfs(sr, sc);
			System.out.println(Ans);
		}
	}

	private static void bfs(int r, int c) {
		Queue<Point> queue = new LinkedList<>();
		queue.add(new Point(r, c));
		board[r][c] = 0;
		visit[r][c] = true;

		while (!queue.isEmpty()) {
			Point p = queue.poll();

			if (p.r == er && p.c == ec) {
				Ans = board[p.r][p.c];
				break;
			}
			for (int d = 0; d < 8; d++) {
				int nr = p.r + dr[d];
				int nc = p.c + dc[d];

				if (nr < 0 || nc < 0 || nr >= N || nc >= N || visit[nr][nc]) {
					continue;
				}

				board[nr][nc] = board[p.r][p.c] + 1;
				visit[nr][nc] = true;
				queue.add(new Point(nr, nc));
			}
		}
	}

	static class Point {

		int r, c;

		public Point(int r, int c) {
			super();
			this.r = r;
			this.c = c;
		}

	}
}
