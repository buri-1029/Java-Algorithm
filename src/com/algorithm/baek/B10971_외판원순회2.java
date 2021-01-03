package com.algorithm.baek;

import java.util.Scanner;

public class B10971_외판원순회2 {
	static int N, ans = Integer.MAX_VALUE;
	static int[][] map;
	static boolean[] visit;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		map = new int[N + 1][N + 1];
		visit = new boolean[N + 1];

		for (int i = 1; i < N + 1; i++) {
			for (int j = 1; j < N + 1; j++) {
				map[i][j] = sc.nextInt();
			}
		}
		backTracking(1, 1, 0); // 시작위치, 방문개수, 비용
		System.out.println(ans);
	}

	private static void backTracking(int cur, int cnt, int cost) {
		if (cnt == N) {
			if(map[cur][1] != 0) {
				ans = Math.min(ans, cost + map[cur][1]);
			}
			return;
		}

		for (int i = 2; i <= N; i++) {
			if (!visit[i] && map[cur][i] != 0) {
				visit[i] = true;
				backTracking(i, cnt + 1, cost + map[cur][i]);
				visit[i] = false;
			}
		}
	}
}
