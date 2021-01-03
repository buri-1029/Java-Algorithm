package com.algorithm.baek;

import java.util.Scanner;

public class B8320_직사각형 {
	/** 최대로 구할 수 있는 직사각형 개수 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();
		int cnt = 0;
		
		for(int i=1;i<=N;i++) { //가로 
			for(int j=i;j<=N;j++) { //세로
				if(i*j<=N) cnt++; //가로*세로(넓이)가 N과 같거나 작을때 개수 증가
			}
		}		
		System.out.println(cnt);
	}

}
