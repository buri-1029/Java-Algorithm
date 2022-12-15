package programmers.level2;

import java.util.Stack;

public class P131704_택배상자 {

	public static void main(String[] args) {
		int[] order1 = {4, 3, 1, 2, 5};
		int[] order2 = {5, 4, 3, 2, 1};

		System.out.println(solution(order1));
		System.out.println(solution(order2));
	}

	public static int solution(int[] order) {

		Stack<Integer> stack = new Stack<>();

		int answer = 0;
		int num = 0;

		for (int i = 1; i <= order.length; i++) {

			if (order[num] != i) {
				stack.add(i);
				continue;
			}

			num++;
			answer++;

			while (stack.size() != 0 && order[num] == stack.peek()) {
				stack.pop();
				num++;
				answer++;
			}
		}

		return answer;
	}
}
