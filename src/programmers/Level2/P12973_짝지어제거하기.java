package programmers.Level2;

import java.util.Stack;

public class P12973_짝지어제거하기 {

	public static void main(String[] args) {
		String s1 = "baabaa";
		String s2 = "cdcd";

		System.out.println(solution(s1));
		System.out.println(solution(s2));
	}

	private static int solution(String s) {
		Stack<Character> str = new Stack<>();
		str.push(s.charAt(0));

		for (int i = 1; i < s.length(); i++) {
			if (!str.empty() && str.peek() == s.charAt(i)) {
				str.pop();
			} else {
				str.push(s.charAt(i));
			}

		}

		return str.empty() ? 1 : 0;
	}

}
