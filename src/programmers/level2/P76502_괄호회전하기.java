package programmers.level2;

import java.util.Stack;

public class P76502_괄호회전하기 {

	public static void main(String[] args) {
		String s1 = "[](){}";
		String s2 = "}]()[{";
		String s3 = "[)(]";
		String s4 = "}}}";

		System.out.println(solution(s1));
		System.out.println(solution(s2));
		System.out.println(solution(s3));
		System.out.println(solution(s4));
	}

	public static int solution(String s) {
		int answer = 0;

		for (int i = 0; i < s.length(); i++) {
			answer += (check(s)) ? 1 : 0;
			s = s.substring(1) + s.charAt(0);
		}

		return answer;
	}

	private static boolean check(String s) {
		Stack<Character> stack = new Stack<>();

		for (int i = 0; i < s.length(); i++) {
			if (s.charAt(i) == '(' || s.charAt(i) == '[' || s.charAt(i) == '{') {
				stack.push(s.charAt(i));
			} else {
				if (!stack.isEmpty()) {
					char c = stack.pop();

					if (c == '(' && s.charAt(i) == ')' ||
						c == '[' && s.charAt(i) == ']' ||
						c == '{' && s.charAt(i) == '}') {
						continue;
					} else {
						return false;
					}
				} else {
					return false;
				}
			}
		}

		if (stack.isEmpty()) {
			return true;
		} else {
			return false;
		}
	}


}
