package programmers.level2;

import java.util.LinkedList;
import java.util.Queue;

public class P118667_두큐합같게만들기 {

	public static void main(String[] args) {
		int[] queue1 = {3, 2, 7, 2};
		int[] queue2 = {4, 6, 5, 1};
		System.out.println(solution(queue1, queue2));
	}

	public static int solution(int[] queue1, int[] queue2) {
		Queue<Integer> que1 = new LinkedList<>();
		Queue<Integer> que2 = new LinkedList<>();

		long sum1 = 0, sum2 = 0;
		int cnt = 0;
		for (int q : queue1) {
			sum1 += q;
			que1.offer(q);
		}

		for (int q : queue2) {
			sum2 += q;
			que2.offer(q);
		}

		while (sum1 != sum2) {
			cnt++;

			if (sum1 > sum2) {
				int n = que1.poll();
				sum1 -= n;
				sum2 += n;
				que2.offer(n);
			} else {
				int n = que2.poll();
				sum1 += n;
				sum2 -= n;
				que1.offer(n);
			}

			if (cnt > (queue1.length + queue2.length) * 2) {
				return -1;
			}
		}

		return cnt;
	}
}
