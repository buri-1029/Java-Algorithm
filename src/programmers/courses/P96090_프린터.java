package programmers.courses;

import java.util.LinkedList;
import java.util.List;

public class P96090_프린터 {

	public static void main(String[] args) {
		int[] priorities = {2, 1, 3, 2};
		int location = 2;

		int[] priorities2 = {1, 1, 9, 1, 1, 1};
		int location2 = 0;

		System.out.println(solution(priorities, location));
		System.out.println(solution(priorities2, location2));
	}

	private static int solution(int[] priorities, int location) {
		List<Paper> queue = new LinkedList<>();

		for (int i = 0; i < priorities.length; i++) {
			queue.add(new Paper(i == location, priorities[i]));
		}

		int answer = 0;
		while (!queue.isEmpty()) {
			Paper paper = queue.remove(0);
			boolean flag = true;

			for (Paper p : queue) {
				if (paper.priority < p.priority) {
					flag = false;
					break;
				}
			}

			if (!flag) {
				queue.add(paper);
				continue;
			}

			answer++;
			if (paper.isMine) {
				return answer;
			}
		}

		return answer;
	}

	public static class Paper {

		boolean isMine;
		int priority;

		public Paper(boolean isMine, int priority) {
			this.isMine = isMine;
			this.priority = priority;
		}
	}
}
