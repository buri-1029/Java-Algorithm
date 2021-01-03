package com.algorithm.baek;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;
import java.util.Stack;

public class B17608_막대기 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		/* stack 사용 */
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(in.readLine());

		Stack<Integer> stack = new Stack<Integer>();
		for (int i = 0; i < N; i++) {
			int height = Integer.parseInt(in.readLine());
			while (!stack.isEmpty() && stack.peek() <= height)
				stack.pop();
			stack.push(height);
		}
		System.out.println(stack.size());
		
		
		/* 구현 */
		Scanner sc = new Scanner(System.in);
		int M = sc.nextInt();
		int[] heights = new int[M];

		for (int i = 0; i < M; i++) {
			heights[i] = sc.nextInt();
		}

		int cnt = 1;
		int last = heights[M - 1];
		for (int i = M - 2; i >= 0; i--) {
			if (heights[i] > last) {
				cnt++;
				last = heights[i]; // 더 큰 막대기로 비교대상 change!
			}
		}
		System.out.println(cnt);
	}
}
