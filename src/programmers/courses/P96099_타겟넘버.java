package programmers.courses;

import java.util.LinkedList;
import java.util.Queue;

public class P96099_타겟넘버 {

	public static void main(String[] args) {
		int[] numbers = {1, 1, 1, 1, 1};
		int target = 3;
		System.out.println(solution(numbers, target));

		int[] numbers1 = {4, 1, 2, 1};
		int target1 = 4;
		System.out.println(solution(numbers1, target1));
	}

	public static int solution(int[] numbers, int target) {
		return sumCount(numbers, target, 0, 0);

		// 내 방법
		// int answer = bfs(numbers, target);
	}

	public static int sumCount(final int[] numbers, final int target, int idx, int sum) {
		if (idx == numbers.length) {
			if (sum == target) {
				return 1;
			}
			return 0;
		}

		return sumCount(numbers, target, idx + 1, sum + numbers[idx]) +
			sumCount(numbers, target, idx + 1, sum - numbers[idx]);
	}

	private static int bfs(int[] numbers, int target) {
		int cnt = 0;

		Queue<Number> queue = new LinkedList<>();
		queue.add(new Number(0, -numbers[0]));
		queue.add(new Number(0, numbers[0]));

		while (!queue.isEmpty()) {
			Number cur = queue.poll();

			if (cur.idx == (numbers.length - 1) && cur.sum == target) {
				cnt++;
			}

			int next = cur.idx + 1;
			if (next < numbers.length) {
				queue.add(new Number(next, cur.sum - numbers[next]));
				queue.add(new Number(next, cur.sum + numbers[next]));
			}

		}

		return cnt;
	}


	static class Number {

		int idx, sum;

		public Number(int idx, int sum) {
			this.idx = idx;
			this.sum = sum;
		}
	}
}
