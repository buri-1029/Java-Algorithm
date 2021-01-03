package com.algorithm.baek;

import java.util.Scanner;
/*
 *	달팽이 배열로 풀어보기 
 */
public class B10157_자리배정 {
	static int map[][];

	// 상 우 하 좌
	static int dr[] = { -1, 0, 1, 0 };
	static int dc[] = { 0, 1, 0, -1 };
	static int cnt = 1;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int C = sc.nextInt();
		int R = sc.nextInt();
		int K = sc.nextInt();

		int[][] map = new int[R][C];

		if (C * R < K) {
			System.out.println(0);
			System.exit(0);
		}

		int r = R - 1, c = 0;
		int num = 1, dir = 0;
		
		while (num != K) {
			map[r][c] = num++;
			int nr = r + dr[dir];
			int nc = c + dc[dir];

			if (nr < 0 || nc < 0 || nr >= R && nc >= C || map[nr][nc] != 0) {
				dir++;
				if (dir == 4) dir = 0;
				nr = r + dr[dir];
				nc = c + dc[dir];
			}
			r = nr;
			c = nc;
		}
		System.out.println((R - r) + " " + (c + 1));
	}
}
