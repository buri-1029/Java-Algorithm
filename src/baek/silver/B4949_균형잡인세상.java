package baek.silver;

import java.util.Scanner;
import java.util.Stack;

public class B4949_균형잡인세상 {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);

		while (true) {
			String input = scan.nextLine();
			if (input.equals(".")) {
				break;
			}

			Stack<Character> check = new Stack<>();

			for (int i = 0; i < input.length(); i++) {
				if (input.charAt(i) == '(') {
					check.push('(');
				} else if (input.charAt(i) == '[') {
					check.push('[');
				} else if (input.charAt(i) == ')') {
					if (!check.isEmpty() && check.peek() == '(') {
						check.pop();
					} else {
						check.push(')');
					}
				} else if (input.charAt(i) == ']') {
					if (!check.isEmpty() && check.peek() == '[') {
						check.pop();
					} else {
						check.push(']');
					}
				}
			}

			if (check.isEmpty()) {
				System.out.println("yes");
			} else {
				System.out.println("no");
			}
		}
	}

}
