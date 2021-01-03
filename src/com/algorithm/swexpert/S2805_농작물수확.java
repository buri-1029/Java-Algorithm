package com.algorithm.swexpert;

import java.util.Scanner;

//농작물 마름모 모양만 수확하기 
public class S2805_농작물수확 {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int T, N;
		int c1, c2;
		
		T = sc.nextInt();
		for(int tc=1;tc<=T;tc++) {
			int SUM=0;
			N = sc.nextInt();
			int [][] arr = new int[N][N];
			
			for(int i=0;i<N;i++) {
				String str = sc.next(); //String문자열로 받아서
				for(int j=0;j<N;j++) {
					arr[i][j] = str.charAt(j)-'0';	//문자 하나하나 int 배열에 저장
				}
			}
			
			c1 = c2 = N/2;
			
			//마름모 모양 확인
			for(int i=0;i<N;i++) {
				for(int j=c1;j<=c2;j++) { //
					SUM+=arr[i][j];
				}
				if(i < N/2) { 
					c1--;
					c2++;
				}else {
					c1++;
					c2--;
				}
			}
			System.out.println("#" + tc + " " + SUM);
		}
	}		
}