package programmers.level2;

import java.util.Stack;

public class P42883_큰수만들기 {

	public static void main(String[] args) {
		String number = "1924";
		int k = 2;
		System.out.println(solution1(number, k));

		String number1 = "1231234";
		int k1 = 3;
		System.out.println(solution2(number1, k1));
	}

	public static String solution2(String number, int k) {
		char[] result = new char[number.length() - k];
		Stack<Character> stack = new Stack<>();

		for (int i = 0; i < number.length(); i++) {
			char ch = number.charAt(i);

			while (!stack.isEmpty() && stack.peek() < ch && k-- > 0) {
				stack.pop();
			}

			stack.push(ch);
		}

		for (int i = 0; i < result.length; i++) {
			result[i] = stack.get(i);
		}

		return new String(result);
	}

	public static String solution1(String number, int k) {
		StringBuilder answer = new StringBuilder();
		int idx = 0;

		for (int i = 0; i < number.length() - k; i++) {
			int max = 0;

			for (int j = idx; j <= k + i; j++) {
				if (max < number.charAt(j) - '0') {
					max = number.charAt(j) - '0';
					idx = j + 1;
				}
			}

			answer.append(max);
		}

		return answer.toString();
	}
}
