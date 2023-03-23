package baek.silver;

import java.util.Scanner;

public class B1189_컴백홈 {

	static int R, C, K;
	static char[][] map;
	static int[][] visited;
	static int answer;

	static int[] dr = {1, -1, 0, 0};
	static int[] dc = {0, 0, 1, -1};

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		R = scan.nextInt();
		C = scan.nextInt();
		K = scan.nextInt();

		map = new char[R][C];
		visited = new int[R][C];

		for (int i = 0; i < R; i++) {
			String s = scan.next();

			for (int j = 0; j < C; j++) {
				map[i][j] = s.charAt(j);
			}
		}

		visited[R - 1][0] = 1;
		dfs(R - 1, 0, 1);

		System.out.println(answer);

	}

	static void dfs(int r, int c, int moved) {
		if (r == 0 && c == C - 1) {
			if (moved == K) {
				answer++;
			}

			return;
		}

		for (int i = 0; i < 4; i++) {
			int nextR = r + dr[i];
			int nextC = c + dc[i];

			if (nextR < 0 || nextR >= R || nextC < 0 || nextC >= C ||
				visited[nextR][nextC] == 1 || map[nextR][nextC] == 'T') {
				continue;
			}

			visited[nextR][nextC] = 1;
			dfs(nextR, nextC, moved + 1);
			visited[nextR][nextC] = 0;
		}
	}
}
