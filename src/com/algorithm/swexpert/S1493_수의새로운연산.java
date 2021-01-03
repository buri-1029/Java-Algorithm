package com.algorithm.swexpert;

import java.util.Scanner;

public class S1493_수의새로운연산 {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();

		// 배열에 미리 값을 구해 놓기
		int[][] map = new int[301][301];
		int num = 1;
		for (int i = 0; i <= 300; i++) {
			for (int j = i; j >= 0; j--) {
				map[i - j][j] = num++;
			}
		}

		for (int tc = 1; tc <= T; tc++) {
			int result = 0;
			int p = sc.nextInt();
			int q = sc.nextInt();

			int px = 0, py = 0, qx = 0, qy = 0;

			// &(p):값이 p인 곳의 x, y 좌표 알아내기
			// &(q):값이 q인 곳의 x, y 좌표 알아내기
			for (int i = 0; i <= 300; i++) {
				for (int j = 0; j <= 300; j++) {
					if (map[i][j] == p) {
						px = i;
						py = j;
					}

					if (map[i][j] == q) {
						qx = i;
						qy = j;
					}
				}
			}
			System.out.println("#" + tc + " " + map[px + qx + 1][py + qy + 1]);
		}

	}
}
