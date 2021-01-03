package com.algorithm.baek;

import java.util.Arrays;
import java.util.Scanner;
/*
 * 백준 - 구현
 *
 */
public class B1475_방번호 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String N = sc.next();

		int[] num = new int[10];

		for (int i = 0; i < N.length(); i++) {
			if (N.charAt(i) - '0' == 6 || N.charAt(i) - '0' == 9) {
				int idx = num[6] < num[9] ? 6 : 9;
				num[idx] += 1;
			}else {
				num[N.charAt(i) - '0']++;
			}
		}
		Arrays.sort(num);
		System.out.println(num[9]);
	}
}
