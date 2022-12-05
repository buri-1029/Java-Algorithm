package programmers.level1;

import java.util.Stack;

public class P133502_햄버거만들기 {

	public static void main(String[] args) {
		int[] ingredient1 = {2, 1, 1, 2, 3, 1, 2, 3, 1};
		System.out.println(solution(ingredient1));

		int[] ingredient2 = {1, 3, 2, 1, 2, 1, 3, 1, 2};
		System.out.println(solution(ingredient2));
	}

	public static int solution(int[] ingredient) {
		int answer = 0;

		Stack<Integer> stack = new Stack<>();

		for (int in : ingredient) {
			stack.push(in);

			if (stack.size() >= 4) {

				if (stack.get(stack.size() - 4) == 1 &&
					stack.get(stack.size() - 3) == 2 &&
					stack.get(stack.size() - 2) == 3 &&
					stack.get(stack.size() - 1) == 1
				) {
					answer++;
					stack.pop();
					stack.pop();
					stack.pop();
					stack.pop();
				}
			}
		}

		return answer;
	}


}
