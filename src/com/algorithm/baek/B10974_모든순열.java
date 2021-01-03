package com.algorithm.baek;

import java.util.Scanner;

/** 
 * N이 주어졌을 때, 1부터 N까지의 수로 이루어진 순열을 사전순으로 출력
 * (Next_Permutation 이용해서 풀어보기)
 * 
 */
public class B10974_모든순열 {
	static int N;
	static int[] sel;
	static boolean[] v;

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		sel = new int[N];
		v = new boolean[N];
		permutation(0);
	}

	private static void permutation(int k) {
		// TODO Auto-generated method stub
		if (k == N) {
			for(int i = 0;i<N;i++) {
				System.out.print(sel[i]+" ");
			}
			System.out.println();
			return;
		}

		for (int i = 0; i < N; i++) {
			if (!v[i]) {
				v[i] = true;
				sel[k] = i + 1;
				permutation(k + 1);
				v[i] = false;
			}
		}
	}
}
