package com.algorithm.baek;

import java.util.Scanner;

public class B1992_쿼드트리 {
	static int N;
	static int[][] map;

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		map = new int[N][N];

		for (int i = 0; i < N; i++) {
			String str = sc.next();
			for (int j = 0; j < N; j++) {
				map[i][j] = str.charAt(j) - '0';
			}
		}
		QuadTree(N, 0, 0); // 영상 압축 시작, 
	}

	private static void QuadTree(int n, int i, int j) {
		boolean zero = true;
		boolean one = true;

		for (int p = i; p < i + n; p++) {
			for (int q = j; q < j + n; q++) {
				if (map[p][q] == 0) {
					one = false;
				} else {
					zero = false;
				}
			}
		}

		if (zero) {
			System.out.print("0");
		} else if (one) {
			System.out.print("1");
		} else {
			System.out.print("(");
			QuadTree(n / 2, i, j); 					// 왼쪽 위
			QuadTree(n / 2, i, j + n / 2);			// 오른쪽 위
			QuadTree(n / 2, i + n / 2, j);			// 왼쪽 아래
			QuadTree(n / 2, i + n / 2, j + n / 2);	// 오른쪽 아래
			System.out.print(")");
		}
		return;
	}
}
