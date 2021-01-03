package com.algorithm.baek;

import java.util.Scanner;

public class B2609_최대공약수와최소공배수 {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int a = sc.nextInt();
		int b = sc.nextInt();
		int c = a*b;
		
		// 유클리드(a를  b로 나눈 나머지가 0보다 클 때까지 반복)
		while (b > 0) {
			int temp = b;
			b = a % b;
			a = temp;
		}
		
		// 최대공약수 
		System.out.println(a);
		// 최대공배수 = 0이 아닌 두 수의 곱/ 두 수의 최대 공약수
		System.out.println(c/a);
	}
}
