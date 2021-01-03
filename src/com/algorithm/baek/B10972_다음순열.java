package com.algorithm.baek;

import java.util.Scanner;

/** 
 * 주어진 순열의 다음에 오는 순열을 출력 → Next_Permutation
 * 
 */
public class B10972_다음순열 {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int[] num = new int[N];

		for (int i = 0; i < N; i++) {
			num[i] = sc.nextInt();
		}
		
		if(next_permutation(num)) {
			for(int i=0;i<N;i++) {
				System.out.print(num[i]+" ");
			}
		}else {
			System.out.println(-1);
		}
	}

	private static boolean next_permutation(int[] num) {
		// TODO Auto-generated method stub
		int i = num.length - 1;
		while (i > 0 && num[i - 1] >= num[i])
			--i;
		if (i == 0)
			return false;

		int j = num.length - 1;
		while (num[j] <= num[i - 1])
			--j;

		swap(num, i - 1, j);

		int k = num.length - 1;
		while (i < k) {
			swap(num, i++, k--);
		}
		return true;
	}

	private static void swap(int[] num, int i, int j) {
		// TODO Auto-generated method stub
		int temp = num[i];
		num[i] = num[j];
		num[j] = temp;
	}
}
