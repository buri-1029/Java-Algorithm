package programmers.level2;

import java.util.Arrays;
import java.util.Stack;

public class P154539_뒤에있는수찾기 {

	public static void main(String[] args) {
		int[] numbers = {9, 1, 5, 3, 6, 2};
		System.out.println(Arrays.toString(solution2(numbers)));
	}

	public static int[] solution2(int[] numbers) {
		int[] answer = new int[numbers.length];
		Arrays.fill(answer, -1);

		Stack<Integer> stack = new Stack<>();

		for (int i = 0; i < numbers.length; i++) {
			if (!stack.isEmpty() && numbers[i] >= numbers[i - 1]) {
				while (!stack.isEmpty() && numbers[stack.peek()] < numbers[i]) {
					answer[stack.pop()] = numbers[i];
				}
			}
			stack.push(i);
		}

		return answer;
	}

	// 시간초과
	public static int[] solution1(int[] numbers) {
		int[] answer = new int[numbers.length];

		for (int i = 0; i < numbers.length - 1; i++) {
			for (int j = i + 1; j < numbers.length; j++) {
				if (numbers[i] < numbers[j]) {
					answer[i] = numbers[j];
					break;
				}
			}

			if (answer[i] == 0) {
				answer[i] = -1;
			}
		}

		answer[numbers.length - 1] = -1;

		return answer;
	}
}
