package com.algorithm.baek;

import java.util.Scanner;

public class B14501_퇴사 {
	static int N, pay, MAX = Integer.MIN_VALUE;
	static int[] TIME;
	static int[] PAY;
	static boolean[] sel;

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		TIME = new int[N];
		PAY = new int[N];
		sel = new boolean[N];

		for (int i = 0; i < N; i++) {
			TIME[i] = sc.nextInt();
			PAY[i] = sc.nextInt();
		}
		
		consult(0,0);
		System.out.println(MAX);
	}

	private static void consult(int day, int pay) {
		if (day >= N) {
			MAX = Math.max(MAX, pay);
			return;
		}
		
		if (day + TIME[day] <= N) {
			consult(day + TIME[day], pay + PAY[day]);
		}
		
		consult(day + 1, pay);
	}
}