package com.algorithm.baek;

import java.util.Scanner;
/*
 * 백준 - 구현
 * 
 */
public class B7568_덩치 {
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		
		int[] weight = new int[n];
		int[] height = new int[n];
		int[] ans = new int[n];
		
		for(int i = 0; i < n; i++) {
			weight[i] = sc.nextInt();
			height[i] = sc.nextInt();
		}
		
		for(int i = 0; i < n; i++) {
			int cnt = 1;
			for(int j = 0; j < n; j++) {
				if(weight[i] < weight[j] && height[i] < height[j]) {
					cnt++;
				}
			}
			ans[i] = cnt;
		}
		
		for(int i = 0; i < n; i++) {
			System.out.print(ans[i]+" ");
		}
	}

}
