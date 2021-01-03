package com.algorithm.swexpert;

import java.util.Scanner;

public class S4613_러시아국기2 {
	static int Ans = 0, N, M;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for (int tc = 1; tc <= T; tc++) {
			N = sc.nextInt();
			M = sc.nextInt();

			int[] W = new int[N];
			int[] B = new int[N];
			int[] R = new int[N];

			for (int r = 0; r < N; r++) {
				String str = sc.next();
				for (int c = 0; c < M; c++) {
					if (str.charAt(c) == 'W')
						W[r]++;
					else if (str.charAt(c) == 'B')
						B[r]++;
					else if (str.charAt(c) == 'R')
						R[r]++;
				}
			}

			for (int i = 1; i <= N - 2; i++) {
				for (int j = i; j <= N - 2; j++) {
					int WCnt = 0, BCnt = 0, RCnt = 0;
					// 화이트갯수
					for (int k = 0; k < i; k++) {
						WCnt += W[k];
					}
					// 블루갯수
					for (int k = i; k <= j; k++) {
						BCnt += B[k];
					}
					// 레드갯수
					for (int k = j + 1; k < N; k++) {
						RCnt += R[k];
					}
					Ans = Math.max(Ans, WCnt + BCnt + RCnt);
				}
			}
			Ans = N * M - Ans;
			System.out.printf("#%d %d\n", tc, Ans);
		}
	}
}
