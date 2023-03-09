package programmers.level2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;

public class P154540_무인도여행 {

	static char[][] map;
	static boolean[][] visited;
	static ArrayList<Integer> answer = new ArrayList<>();

	static int[] dr = {-1, 1, 0, 0};
	static int[] dc = {0, 0, -1, 1};

	public static void main(String[] args) {
		String[] maps = {"X591X", "X1X5X", "X231X", "1XXX1"};
		System.out.println(Arrays.toString(solution(maps)));
	}

	public static int[] solution(String[] maps) {
		map = new char[maps.length][maps[0].length()];
		visited = new boolean[maps.length][maps[0].length()];

		for (int i = 0; i < maps.length; i++) {
			for (int j = 0; j < maps[0].length(); j++) {
				map[i][j] = maps[i].charAt(j);
			}
		}

		for (int i = 0; i < map.length; i++) {
			for (int j = 0; j < map[i].length; j++) {
				if (!visited[i][j] && map[i][j] != 'X') {
					bfs(i, j);
				}
			}
		}

		Collections.sort(answer);

		if (answer.size() == 0) {
			answer.add(-1);
		}

		return answer.stream()
					 .mapToInt(Integer::intValue)
					 .toArray();
	}

	private static void bfs(int r, int c) {
		Queue<Point> queue = new LinkedList<>();
		queue.add(new Point(r, c));
		visited[r][c] = true;

		int sum = 0;
		while (!queue.isEmpty()) {
			Point cur = queue.poll();

			sum += map[cur.r][cur.c] - '0';

			for (int d = 0; d < 4; d++) {
				int nr = cur.r + dr[d];
				int nc = cur.c + dc[d];

				if (nr >= 0 && nr < map.length && nc >= 0 && nc < map[0].length
					&& map[nr][nc] != 'X' && !visited[nr][nc]) {
					queue.add(new Point(nr, nc));
					visited[nr][nc] = true;
				}
			}
		}

		answer.add(sum);
	}

	static class Point {

		int r, c;

		public Point(int r, int c) {
			this.r = r;
			this.c = c;
		}
	}
}

