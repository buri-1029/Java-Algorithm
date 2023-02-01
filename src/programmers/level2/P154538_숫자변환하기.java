package programmers.level2;

import java.util.HashSet;
import java.util.PriorityQueue;

public class P154538_숫자변환하기 {

	public static void main(String[] args) {
		int x = 10;
		int y = 20;
		int n = 30;

		System.out.println(solution(x, y, n));

	}

	public static int solution(int x, int y, int n) {
		int answer = 0;

		if (x == y) {
			return -1;
		}

		PriorityQueue<Info> pq = new PriorityQueue<>();
		HashSet<Integer> exist = new HashSet<>();

		pq.add(new Info(x, 0));
		exist.add(x);

		while (!pq.isEmpty()) {
			Info cur = pq.poll();

			if (cur.num == y) {
				answer = cur.cnt;
				break;
			}

			if (cur.num + n <= y && !exist.contains(cur.num + n)) {
				pq.add(new Info(cur.num + n, cur.cnt + 1));
				exist.add(cur.num + n);
			}
			if (cur.num * 2 <= y && !exist.contains(cur.num * 2)) {
				pq.add(new Info(cur.num * 2, cur.cnt + 1));
				exist.add(cur.num * 2);
			}
			if (cur.num * 3 <= y && !exist.contains(cur.num * 3)) {
				pq.add(new Info(cur.num * 3, cur.cnt + 1));
				exist.add(cur.num * 3);
			}

		}

		return answer == 0 ? -1 : answer;
	}

	public static class Info implements Comparable<Info> {

		int num;
		int cnt;

		public Info(int num, int cnt) {
			this.num = num;
			this.cnt = cnt;
		}

		@Override
		public int compareTo(Info o) {
			if (this.cnt == o.cnt) {
				return this.num - o.num;
			}

			return this.cnt - o.cnt;
		}
	}

}
