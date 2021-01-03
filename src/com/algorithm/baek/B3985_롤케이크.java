package com.algorithm.baek;

import java.util.Scanner;

/** 
 * 롤 케이크를 먹고 싶은 만큼 입력받았을 때 기대 MAX값 , 실제 MAX값 구하기
 * 
 */
public class B3985_롤케이크 {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int R,N,P,K; // R : 롤케이크 길이, N : 방청객 수 
		int MAX1=0,MAX2=0,MAX1_index=0, MAX2_index=0;
		
		R=sc.nextInt();
		N=sc.nextInt();
		int[] r = new int[R]; //롤케이크 배열에 어떤 관객이 먹었는지 표시
		int[] n = new int[N]; //각 관객이 케이크를 먹은 수 표시
				
		for(int i=1;i<=N;i++) {
			P = sc.nextInt();
			K = sc.nextInt();
			
			for(int j=P;j<=K;j++) {
				if(r[j-1] == 0) {
					r[j-1] = i; n[i-1]++;
				}				
			}
			if(MAX1<K-P+1) {
				MAX1 = K-P+1;
				MAX1_index = i;
			}
			if(MAX2<n[i-1]) {
				MAX2 = n[i-1];
				MAX2_index = i;
			}			
		}
		System.out.println(MAX1_index);
		System.out.println(MAX2_index);
	}

}
