package com.algorithm.baek;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;
import java.util.Stack;
import java.util.StringTokenizer;

public class B2493_탑 {
	static int N, num, top;

	public static void main(String[] args) throws IOException {
		Stack<Integer> stack = new Stack<>();
		Stack<Integer> index = new Stack<>();
		
		//Scanner sc = new Scanner(System.in);
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(in.readLine());
		StringTokenizer st = new StringTokenizer(in.readLine());
		
		num = Integer.parseInt(st.nextToken());
		stack.push(num);
		index.push(1);
		System.out.print("0");

		for (int i = 2; i <= N; i++) {
			num = Integer.parseInt(st.nextToken());
			while (true) {
				if (!stack.empty()) {
					top = stack.peek();
					if (top > num) {
						System.out.print(" " + index.peek());
						stack.push(num);
						index.push(i);
						break;
					} else {
						stack.pop();
						index.pop();
					}
				} else {
					System.out.print(" 0");
					stack.push(num);
					index.push(i);
					break;
				}
			}
		}
	}
}