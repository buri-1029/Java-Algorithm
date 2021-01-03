package com.algorithm.swexpert;

import java.util.Arrays;
import java.util.Scanner;

//정렬 이용
public class S1208_Flatten {
	static int D;
	static int N[] = new int[100];
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in); 
		
		for(int tc=1;tc<=10;tc++) {
			D = sc.nextInt();
			for(int i=0;i<100;i++) {
				N[i] = sc.nextInt();
			}
			Arrays.sort(N);
			
			for(int i=0;i<D;i++) {
				N[0]++;
				N[99]--;
				Arrays.sort(N);
			}
			int res = N[99] - N[0];
			System.out.println("#"+tc+" "+res);
		}
	}
}
