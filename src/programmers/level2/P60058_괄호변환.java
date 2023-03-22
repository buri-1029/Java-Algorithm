package programmers.level2;

import java.util.Stack;

public class P60058_괄호변환 {

	static int split;

	public static void main(String[] args) {
		String p1 = "(()())()";
		System.out.println(solution(p1));

		String p2 = ")(";
		System.out.println(solution(p2));
	}

	public static String solution(String p) {
		String answer = "";

		if (p.equals("")) {
			return p;
		}

		boolean right = isRight(p);

		String u = p.substring(0, split);
		String v = p.substring(split);

		if (right) {
			return u + solution(v);
		}

		answer = "(" + solution(v) + ")";

		for (int i = 1; i < u.length() - 1; i++) {
			if (u.charAt(i) == '(') {
				answer += ")";
			} else {
				answer += "(";
			}
		}

		return answer;
	}

	public static boolean isRight(String p) {
		Stack<Character> stack = new Stack<>();

		boolean flag = true;
		int left = 0;
		int right = 0;

		for (int i = 0; i < p.length(); i++) {
			if (p.charAt(i) == '(') {
				left++;
				stack.push('(');
			} else {
				right++;
				if (!stack.isEmpty()) {
					stack.pop();
				} else {
					flag = false;
				}
			}

			if (left == right) {
				split = i + 1;
				return flag;
			}
		}

		return flag;
	}
}
