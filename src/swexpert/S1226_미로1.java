package swexpert;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class S1226_미로1 {
	static int[][] maze;
	static int sr, sc, res = 0;
	static int[] dr = { 1, -1, 0, 0 };
	static int[] dc = { 0, 0, 1, -1 };

	static class Point {
		int r, c;

		Point(int r, int c) {
			this.r = r;
			this.c = c;
		}
	}

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		// TODO Auto-generated method stub
		for (int tc = 1; tc <= 10; tc++) {
			int N = scan.nextInt();
			maze = new int[16][16];
			res = 0; // 도달 가능 여부 변수 >> 테케 다시 시작할 때 다시 0으로..

			for (int r = 0; r < 16; r++) {
				String input = scan.next();
				for (int c = 0; c < 16; c++) {
					maze[r][c] = input.charAt(c) - '0';

					if (maze[r][c] == 2) { // 시작점 2인 좌표
						sr = r; // 따로 저장해서
						sc = c; // bfs(시작점 좌표 인수로 주기)
					}
				}
			}
			bfs(sr, sc);
			System.out.println("#" + tc + " " + res);
		}
	}

	private static void bfs(int r, int c) {
		// TODO Auto-generated method stub
		Queue<Point> Q = new LinkedList();
		Q.add(new Point(r, c));

		while (!Q.isEmpty()) {
			Point p = Q.poll();
			for (int k = 0; k < 4; k++) {
				int nr = p.r + dr[k];
				int nc = p.c + dc[k];
				if (nr >= 0 && nr < 16 && nc >= 0 && nc < 16 && maze[nr][nc] == 0) {
					maze[nr][nc] = 2; // 표시 해도 되고 안해도 되고
					Q.add(new Point(nr, nc));
				} else if (nr >= 0 && nr < 16 && nc >= 0 && nc < 16 && maze[nr][nc] == 3)
					res = 1; // 3 만나면 res = 1
			}
		}

	}
}
