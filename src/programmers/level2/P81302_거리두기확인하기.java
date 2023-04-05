package programmers.level2;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class P81302_거리두기확인하기 {

	static int dr[] = {-1, 1, 0, 0};
	static int dc[] = {0, 0, -1, 1};

	public static void main(String[] args) {
		String[][] places = {{"POOOP", "OXXOX", "OPXPX", "OOXOX", "POXXP"},
			{"POOPX", "OXPXP", "PXXXO", "OXXXO", "OOOPP"},
			{"PXOPX", "OXOXP", "OXPOX", "OXXOP", "PXPOX"},
			{"OOOXX", "XOOOX", "OOOXX", "OXOOX", "OOOOO"},
			{"PXPXP", "XPXPX", "PXPXP", "XPXPX", "PXPXP"}};

		System.out.println(Arrays.toString(solution(places)));
	}

	public static int[] solution(String[][] places) {
		int[] answer = new int[places.length];
		for (int i = 0; i < places.length; i++) {
			answer[i] = check(places[i]);
		}
		return answer;
	}

	private static int check(String[] arr) {
		for (int i = 0; i < arr.length; i++) {
			for (int j = 0; j < arr[i].length(); j++) {
				if (arr[i].charAt(j) == 'P') {
					if (!bfs(arr, i, j)) {
						return 0;
					}
				}
			}
		}

		return 1;
	}

	private static boolean bfs(String[] arr, int r, int c) {
		Queue<Point> q = new LinkedList<>();
		boolean[][] visited = new boolean[arr.length][arr.length];
		q.offer(new Point(r, c));
		visited[r][c] = true;

		while (!q.isEmpty()) {
			Point cur = q.poll();

			for (int i = 0; i < 4; i++) {
				int nr = cur.r + dr[i];
				int nc = cur.c + dc[i];

				if (nr < 0 || nc < 0 || nr >= arr.length || nc >= arr.length || visited[nr][nc]
					|| Math.abs(r - nr) + Math.abs(c - nc) > 2 || arr[nr].charAt(nc) == 'X') {
					continue;
				}

				visited[nr][nc] = true;

				if (arr[nr].charAt(nc) == 'P') {
					return false;
				} else {
					q.offer(new Point(nr, nc));
				}
			}
		}

		return true;
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
