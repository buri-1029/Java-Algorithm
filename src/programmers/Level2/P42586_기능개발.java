package programmers.Level2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.PriorityQueue;

public class P42586_기능개발 {

	public static void main(String[] args) {
		int[] progresses = {40, 93, 30, 55, 60, 65};
		int[] speeds = {60, 1, 30, 5, 10, 7};

		int[] progresses2 = {95, 90, 99, 99, 80, 99};
		int[] speeds2 = {1, 1, 1, 1, 1, 1};

		int[] answer1 = solution(progresses, speeds);
		System.out.println(Arrays.toString(answer1));

		int[] answer2 = solution(progresses2, speeds2);
		System.out.println(Arrays.toString(answer2));
	}

	private static int[] solution(int[] progresses, int[] speeds) {
		ArrayList<Integer> arr = new ArrayList<>();
		PriorityQueue<Integer> queue = new PriorityQueue<>(Collections.reverseOrder());

		for (int i = 0; i < progresses.length; i++) {
			int tmp = (100 - progresses[i]) / speeds[i];
			tmp += (100 - progresses[i]) % speeds[i] != 0 ? 1 : 0;

			if (queue.isEmpty() || queue.peek() >= tmp) {
				queue.add(tmp);
			} else if (queue.peek() < tmp) {
				arr.add(queue.size());
				queue.clear();
				queue.add(tmp);
			}
		}

		arr.add(queue.size());

		int[] answer = new int[arr.size()];
		for (int i = 0; i < answer.length; i++) {
			answer[i] = arr.get(i);
		}

		return answer;
	}

}
