package com.algorithm.baek;

import java.util.Scanner;

public class B2292_벌집 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int ans = 1;

		if(N > 1) ans = 2;
		
		int idx = 1;
		int num = 1;
		for (int i = 3; i <= N; i++) {
			if (i > num + (6 * idx)) {
				ans++;
				idx++;
				num = i - 1;
			}
		}
		System.out.println(ans);
	}
}
