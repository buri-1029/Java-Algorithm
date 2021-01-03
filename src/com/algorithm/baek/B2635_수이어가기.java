package com.algorithm.baek;

import java.util.ArrayList;
import java.util.Scanner;

public class B2635_수이어가기 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();

		ArrayList<Integer> ans = new ArrayList<>();
		for (int i = N; i >= 1; i--) {
			ArrayList<Integer> list = new ArrayList<>();
			list.add(N);
			int num1 = N; // 앞의 앞의 수
			int num2 = i; // 앞의 수
			
			while (true) {
				if (num1 < 0)	break; // 음의 정수가 나오면 끝.
				if (num2 >= 0)	list.add(num2); 
				
				int tmp = num1;
				num1 = num2;
				num2 = tmp - num2;
			}
			if (ans.size() < list.size()) ans = list;
		}
		
		System.out.println(ans.size());
		for(int n : ans) System.out.print(n+" ");
	}
}
