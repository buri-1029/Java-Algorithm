package com.algorithm.swexpert;

import java.util.Scanner;

public class S1954_달팽이숫자 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		
		int T = sc.nextInt();
		for(int tc=1;tc<=T;tc++) {
			int N = sc.nextInt();
			int[][] arr = new int[N][N];
			int cnt = 1,start = 0,last = N-1;
			
			for(int i=0;i<N;i++) {
				if(i%2==0) {
					for(int j=start;j<=last;j++){
						arr[start][j] = cnt++;
					}
					start++;
				}else {
					for(int j=last;j>=start-1;j--) {
						arr[last+1][j] = cnt++;
					}
				}
				
				if(i%2==0) {
					for(int j=start;j<=last;j++) {
						arr[j][last] = cnt++;
					}
					last--;
				}else {
					for(int j=last;j>=start;j--) {
						arr[j][start-1] = cnt++;
					}
				}
			}
			System.out.println("#"+tc);
			for(int i=0;i<N;i++) {
				for(int j=0;j<N;j++) {
					System.out.print(arr[i][j]+" ");
				}
				System.out.println();
			}			
		}		
	}
}
