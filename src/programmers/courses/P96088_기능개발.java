package programmers.courses;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class P96088_기능개발 {

	public static void main(String[] args) {
		int[] progresses1 = {93, 30, 55};
		int[] speed1 = {1, 30, 5};
		System.out.println(Arrays.toString(solution(progresses1, speed1)));

		int[] progresses2 = {95, 90, 99, 99, 80, 99};
		int[] speed2 = {1, 1, 1, 1, 1, 1};
		System.out.println(Arrays.toString(solution(progresses2, speed2)));
	}

	public static int[] solution(int[] progresses, int[] speeds) {
		Queue<Integer> queue = new LinkedList<>();
		for (int i = 0; i < progresses.length; i++) {
			float p = progresses[i], s = speeds[i];
			int days = (int) Math.ceil((100 - p) / s);
			queue.offer(days);
		} // [7/1, 70/30, 45/9] 올림 -> [7, 3, 9]

		Queue<Integer> answer = new LinkedList<>();
		int day = queue.poll();
		int cnt = 1;

		while (!queue.isEmpty()) {
			int next = queue.poll();

			if (day >= next) {
				cnt++;
				continue;
			}

			answer.offer(cnt);
			cnt = 1;
			day = next;
		}

		answer.offer(cnt);

		return answer.stream()
					 .mapToInt(Integer::intValue)
					 .toArray();
	}
}
