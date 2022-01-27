package programmers.Level2;

import java.util.PriorityQueue;

public class P42626_더맵게 {

	public static void main(String[] args) {
		int[] scoville = {1, 2, 3, 9, 10, 12};
		int K = 7;

		System.out.println(solution(scoville, K));
	}

	private static int solution(int[] scoville, int K) {
		PriorityQueue<Integer> queue = new PriorityQueue<>();
		for (int num : scoville) {
			queue.add(num);
		}

		int cnt = 0;
		while (queue.peek() < K) {
			if (queue.size() == 1) {
				cnt = -1;
				break;
			}

			queue.add(queue.poll() + (queue.poll() * 2));
			cnt++;
		}

		return cnt;
	}

}
