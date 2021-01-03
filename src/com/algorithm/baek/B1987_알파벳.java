package com.algorithm.baek;

import java.util.Scanner;

public class B1987_알파벳 {
	static int R, C, max = Integer.MIN_VALUE;
	static char[][] alpha;
	static boolean[] visit = new boolean[26];
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
		R = sc.nextInt();
		C = sc.nextInt();
		alpha = new char[R][C];

		for (int r = 0; r < R; r++) {
			String str = sc.next();
			for (int c = 0; c < C; c++) {
				alpha[r][c] = str.charAt(c);
			}
		}
		
		// ex) 'C'(67) - 'A'(65) = 2
		// visit[2] >> C 를 가리킴
		visit[alpha[0][0] - 'A'] = true; // 첫번째 알파벳은 무조건 방문이니깐,
		dfs(0, 0, 1); 
		
		System.out.println(max);
	}

	private static void dfs(int r, int c, int cnt) {
		max = Math.max(max, cnt); // 방문한 알파벳 개수 최대

		for (int k = 0; k < 4; k++) {
			int nr = r + dr[k];
			int nc = c + dc[k];
			if (nr >= 0 && nr < R && nc >= 0 && nc < C && !visit[alpha[nr][nc] - 'A']) {
				visit[alpha[nr][nc] - 'A'] = true; 	 // 모든 갈 수 있는 경우의 수를 따져야하니깐
				dfs(nr, nc, cnt + 1);				 // powerset과 같은 방법으로 함.
				visit[alpha[nr][nc] - 'A'] = false;
			}
		}
	}
}