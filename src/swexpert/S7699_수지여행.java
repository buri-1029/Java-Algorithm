package swexpert;

import java.util.Scanner;

public class S7699_수지여행 {
	static int R, C, max;
	static char[][] arr; 
	static boolean[] visit;
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
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();

		for (int tc = 1; tc <= T; tc++) {
			R = sc.nextInt();
			C = sc.nextInt();
			arr = new char[R][C]; 	 // 명물 배열
			visit = new boolean[26]; // 알파벳 방문 여부 배열
			max = 0;

			for (int r = 0; r < R; r++) {
				String input = sc.next();
				for (int c = 0; c < C; c++) {
					arr[r][c] = input.charAt(c);
				}
			}
			// ex) 'C'(67) - 'A'(65) = 2
			//      visit[2] >> C 를 가리킴
			visit[arr[0][0] - 'A'] = true; // 첫번째 명물은 무조건 방문이니깐,
			dfs(0, 0, 1); // 명물찾기 (1,1,명물개수)
			System.out.println("#" + tc + " " + max);
		}
	}

	private static void dfs(int r, int c, int cnt) {
		max = Math.max(max, cnt); //명물 개수 최대
		
		for (int k = 0; k < 4; k++) {
			int nr = r + dr[k];
			int nc = c + dc[k];
			if (nr >= 0 && nr < R && nc >= 0 && nc < C && !visit[arr[nr][nc] - 'A']) {
				visit[arr[nr][nc] - 'A'] = true;	//모든 갈 수 있는 경우의 수를 따져야하니깐
				dfs(nr, nc, cnt + 1);				//powerset과 같은 방법으로 함.
				visit[arr[nr][nc] - 'A'] = false;
			}
		}
	}
}
