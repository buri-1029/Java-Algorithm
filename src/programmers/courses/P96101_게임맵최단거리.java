package programmers.courses;

import java.util.LinkedList;
import java.util.Queue;

public class P96101_게임맵최단거리 {

	public static void main(String[] args) {
		int[][] maps = {{1, 0, 1, 1, 1}, {1, 0, 1, 0, 1}, {1, 0, 1, 1, 1},
			{1, 1, 1, 0, 1}, {0, 0, 0, 0, 1}};
		int[][] maps1 = {{1, 0, 1, 1, 1}, {1, 0, 1, 0, 1}, {1, 0, 1, 1, 1},
			{1, 1, 1, 0, 0}, {0, 0, 0, 0, 1}};

		System.out.println(solution(maps));
		System.out.println(solution(maps1));
	}

	public static int solution(int[][] maps) {
		int n = maps.length, m = maps[0].length;
		int answer = Integer.MAX_VALUE;

		int[] dr = {0, 0, 1, -1};
		int[] dc = {1, -1, 0, 0};

		boolean[][] visit = new boolean[n][m];
		Queue<Character> queue = new LinkedList<>();
		queue.add(new Character(0, 0, 1));
		visit[0][0] = true;

		while (!queue.isEmpty()) {
			Character cur = queue.poll();

			if (cur.r == n - 1 && cur.c == m - 1) {
				answer = Math.min(answer, cur.move);
			}

			for (int d = 0; d < 4; d++) {
				int nr = cur.r + dr[d];
				int nc = cur.c + dc[d];

				if (nr >= n || nc >= m || nr < 0 || nc < 0 || visit[nr][nc] || maps[nr][nc] == 0) {
					continue;
				}

				// 큐에 넣기 전 방문처리를 해야 이미 큐에 들어있는 블럭을 또 큐에 넣지 않는다.
				visit[nr][nc] = true;
				queue.add(new Character(nr, nc, cur.move + 1));
			}
		}

		return answer == Integer.MAX_VALUE ? -1 : answer;
	}

	static class Character {

		int r, c, move;

		public Character(int r, int c, int move) {
			this.r = r;
			this.c = c;
			this.move = move;
		}
	}
}
