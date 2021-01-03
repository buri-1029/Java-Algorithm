package com.algorithm.baek;

import java.util.Scanner;

public class B1080_행렬 {
	static int N, M;
	static int[][] A;
	static int[][] B;

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		M = sc.nextInt();

		A = new int[N][M];
		B = new int[N][M];

		for (int i = 0; i < N; i++) {
			String str = sc.next();
			for (int j = 0; j < M; j++) {
				A[i][j] = str.charAt(j) - '0';
			}
		}
		for (int i = 0; i < N; i++) {
			String str = sc.next();
			for (int j = 0; j < M; j++) {
				B[i][j] = str.charAt(j) - '0';
			}
		}

		int cnt = 0;

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if (A[i][j] != B[i][j]) { 	 // A배열의 각 원소와 B배열의 각 원소 비교해서
					if (change(i, j)) {	 	 // 같지 않으면 변환하는 change()로 넘겨준다,
						cnt++; 			  	 // 연산의 횟수 증가					 
					}else {
						System.out.println(-1);
						return;
					}
				}			
			}
		}
		System.out.println(cnt);	
	}

	private static boolean change(int n, int m) {
		
		// 3*3 만큼 돌려주는데 그 범위를 넘어가면 false,
		if (n + 3 > N || m + 3 > M)	 return false; 

		for (int i = n; i < n + 3; i++) {
			for (int j = m; j < m + 3; j++) {
				A[i][j] = 1 - A[i][j]; // 0 -> 1(0-1)
			}						   // 1 -> 0(1-1)
		}
		return true;
	}
}
