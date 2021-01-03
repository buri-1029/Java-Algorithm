package com.algorithm.baek;

import java.util.Scanner;

public class B2563_색종이 {
	public static void main(String[] args) {
		int[][] paper = new int[100][100];
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();

		for (int n = 0; n < N; n++) {
			int a = sc.nextInt();
			int b = sc.nextInt();

			for (int i = b; i < b + 10; i++) {
				for (int j = a; j < a + 10; j++) {
					paper[i][j] = 1;
				}
			}
		}
		int ans = 0;
		for (int i = 0; i < 100; i++) {
			for (int j = 0; j < 100; j++) {
				if (paper[i][j] == 1) {
					ans++;
				}
			}
		}
		System.out.println(ans);
	}
}
