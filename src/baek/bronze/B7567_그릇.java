package baek.bronze;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class B7567_그릇 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] arr = br.readLine()
						 .split("");

		Stack<String> stack = new Stack<>();
		int answer = 0;

		for (String s : arr) {
			if (stack.isEmpty()) {
				stack.add(s);
				answer += 10;
			} else {
				if (stack.peek()
						 .equals(s)) {
					answer += 5;
				} else {
					answer += 10;
				}

				stack.add(s);
			}
		}

		System.out.println(answer);
	}
}
