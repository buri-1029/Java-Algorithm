package com.algorithm.baek;

import java.util.Scanner;

public class B10163_색종이 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt(); // 색종이 개수
		int[][] arr = new int[101][101];
		int[] cnt = new int[N + 1];

		for (int n = 1; n <= N; n++) {
			int a = sc.nextInt();
			int b = sc.nextInt();
			int w = sc.nextInt();
			int h = sc.nextInt();

			for (int i = b; i < b + h; i++) {
				for (int j = a; j < a + w; j++) {
					arr[i][j] = n; 
				}
			}
		}

		for (int i = 0; i < 101; i++) {
			for (int j = 0; j < 101; j++) {
				if (arr[i][j] != 0)
					cnt[arr[i][j]]++;
			}
		}

		for (int i = 1; i <= N; i++)
			System.out.println(cnt[i]);
	}
}
