package programmers.level3;

import java.util.Arrays;
import java.util.Collections;
import java.util.PriorityQueue;

public class P42628_이중우선순위큐 {

	public static void main(String[] args) {
		String[] operations = {"I -45", "I 653", "D 1", "I -642", "I 45", "I 97", "D 1", "D -1",
			"I 333"};
		System.out.println(Arrays.toString(solution(operations)));
	}

	public static int[] solution(String[] operations) {
		PriorityQueue<Integer> pqLowest = new PriorityQueue<>();
		PriorityQueue<Integer> pqHighest = new PriorityQueue<>(Collections.reverseOrder());

		for (String operation : operations) {
			String[] tmp = operation.split(" ");

			if (tmp[0].equals("I")) {
				pqLowest.add(Integer.valueOf(tmp[1]));
				pqHighest.add(Integer.valueOf(tmp[1]));
			} else if (tmp[0].equals("D") && tmp[1].equals("1")) {
				if (pqHighest.isEmpty()) {
					continue;
				}

				int max = pqHighest.poll();
				pqLowest.remove(max);
			} else if (tmp[0].equals("D") && tmp[1].equals("-1")) {
				if (pqLowest.isEmpty()) {
					continue;
				}

				int min = pqLowest.poll();
				pqHighest.remove(min);
			}
		}

		int[] answer = new int[2];

		answer[0] = pqHighest.isEmpty() ? 0 : pqHighest.poll();
		answer[1] = pqLowest.isEmpty() ? 0 : pqLowest.poll();

		return answer;
	}
}
