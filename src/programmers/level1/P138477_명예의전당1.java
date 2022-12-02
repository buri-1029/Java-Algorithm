package programmers.level1;

import java.util.Arrays;
import java.util.PriorityQueue;

public class P138477_명예의전당1 {

	public static void main(String[] args) {
		int k1 = 3;
		int[] score1 = {10, 100, 20, 150, 1, 100, 200};

		int k2 = 4;
		int[] score2 = {0, 300, 40, 300, 20, 70, 150, 50, 500, 1000};

		System.out.println(Arrays.toString(solution(k1, score1)));
		System.out.println(Arrays.toString(solution(k2, score2)));

	}

	public static int[] solution(int k, int[] score) {
		int[] answer = new int[score.length];

		PriorityQueue<Integer> pq = new PriorityQueue<>();
		for (int i = 0; i < score.length; i++) {
			if (!pq.isEmpty() && pq.size() == k) {
				if (pq.peek() < score[i]) {
					pq.poll();
					pq.add(score[i]);
				}
			} else {
				pq.add(score[i]);
			}
			answer[i] = pq.peek();
		}
		return answer;
	}
}
