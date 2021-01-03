package com.algorithm.swexpert;

import java.util.Arrays;
import java.util.Scanner;

/** 조합*/
public class S9229_SpotMart {
	static int[] snacks;
	static int[] sel = new int[2];
	static int T, N, M, SUM;

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);

		T = sc.nextInt();
		for (int tc = 1; tc <= T; tc++) {
			N = sc.nextInt();
			snacks = new int[N];
			M = sc.nextInt();

			for (int n = 0; n < N; n++) {
				snacks[n] = sc.nextInt();
			}
			SUM = -1;
			select_snack(0, 0);
			System.out.println("#"+tc+" "+SUM);
		}
	}

	private static void select_snack(int idx, int k) {
		// TODO Auto-generated method stub
		if (k == sel.length) {
			if (sel[0] + sel[1]<=M) {
				SUM = Math.max(SUM,sel[0] + sel[1]);
			}
			return;
		}

		if (idx == snacks.length)
			return;

		sel[k] = snacks[idx];
		select_snack(idx + 1, k + 1);
		select_snack(idx + 1, k);
	}
}
