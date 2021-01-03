package com.algorithm.baek;

import java.util.Scanner;
import java.util.Stack;

/** 
 * ! 규칙을 지키면서 문자열에서 단어 뒤집기2
 * 
 */
public class B17413_단어뒤집기 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		Stack st = new Stack();

		String s = sc.nextLine();
		boolean check = false;

		for (int i = 0; i < s.length(); i++) {
			if (s.charAt(i) == '<') {
				while (!st.empty()) {
					System.out.print(st.peek());
					st.pop();
				}
				check = true;
				System.out.print(s.charAt(i));
			} else if (s.charAt(i) == '>') {
				check = false;
				System.out.print(s.charAt(i));
			} else if (check) {
				System.out.print(s.charAt(i));
			}

			else {
				if (s.charAt(i) == ' ') {
					while (!st.empty()) {
						System.out.print(st.peek());
						st.pop();
					}
					System.out.print(s.charAt(i));
				}else {
					st.push(s.charAt(i));
				}
			}

		}
		while (!st.empty()) {
			System.out.print(st.peek());
			st.pop();
		}
	}
}
