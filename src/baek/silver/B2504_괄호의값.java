package baek.silver;

import java.util.Scanner;
import java.util.Stack;

public class B2504_괄호의값 {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		String str = scan.next();
		Stack<Character> stack = new Stack<>();
		int answer = 0, tmp = 1;

		for (int i = 0; i < str.length(); i++) {
			if (str.charAt(i) == '(') {
				stack.push(str.charAt(i));
				tmp *= 2;
			} else if (str.charAt(i) == '[') {
				stack.push(str.charAt(i));
				tmp *= 3;
			} else if (str.charAt(i) == ')') {
				if (stack.isEmpty() || stack.peek() != '(') {
					answer = 0;
					break;
				} else if (str.charAt(i - 1) == '(') {
					answer += tmp;
				}
				stack.pop();
				tmp /= 2;
			} else if (str.charAt(i) == ']') {
				if (stack.isEmpty() || stack.peek() != '[') {
					answer = 0;
					break;
				} else if (str.charAt(i - 1) == '[') {
					answer += tmp;
				}

				stack.pop();
				tmp /= 3;
			}
		}

		if (!stack.isEmpty()) {
			System.out.println(0);
		} else {
			System.out.println(answer);
		}

	}

}
