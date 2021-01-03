package com.algorithm.baek;

import java.util.Arrays;
import java.util.Scanner;

/** 
 * 줄 서 있는 N명의 사람이 돈을 인출하는데 필요한 시간의 합의 최솟값 구하기 
 * 
 */
public class B11399_ATM {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int N = sc.nextInt(); // 사람의 수 입력
		int[] p = new int[N]; // 각 사람이 돈을 인출하는 데 걸리는 시간 저장할 배열

		for (int i = 0; i < N; i++) {
			p[i] = sc.nextInt(); // 각 사람이 돈을 인출하는 데 걸리는 시간
		}

		Arrays.sort(p); // 오름차순으로 정렬

		int sum = 0; // 각 사람이 돈을 인출하는데 필요한 최소 시간
		int res = 0; // 총합을 저장할 변수

		for (int i = 0; i < p.length; i++) {
			sum += p[i];
			res += sum;

		}
		System.out.println(res);
	}
}
