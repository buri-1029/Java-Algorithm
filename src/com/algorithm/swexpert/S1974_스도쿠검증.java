package com.algorithm.swexpert;

import java.util.Scanner;

public class S1974_스도쿠검증 {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();

		for (int tc = 1; tc <= T; tc++) {
			int[][] map = new int[9][9];
			boolean flag = true;
			for (int i = 0; i < 9; i++) {
				boolean[] num = new boolean[10];
				for (int j = 0; j < 9; j++) {
					map[i][j] = sc.nextInt();
					if (!num[map[i][j]]) {
						num[map[i][j]] = true;
					} else {
						flag = false;
					}
				}
			}
			for (int i = 0; i < 9; i++) {
				boolean[] num = new boolean[10];
				for (int j = 0; j < 9; j++) {
					if (!num[map[j][i]]) {
						num[map[j][i]] = true;
					} else {
						flag = false;
					}
				}
			}
			/** ***************** */
			for (int i = 0; i < 9; i += 3) {
				for (int j = 0; j < 9; j += 3) {
					boolean[] num = new boolean[10];
					for (int x = i; x < i + 3; x++) {
						for (int y = j; y < j + 3; y++) {
							if (!num[map[x][y]]) {
								num[map[x][y]] = true;
							} else {
								flag = false;
							}
						}
					}
				}
			}
			/** ***************** */
			
			if (flag)
				System.out.println("#" + tc + " " + 1);
			else
				System.out.println("#" + tc + " " + 0);
		}
	}
}
