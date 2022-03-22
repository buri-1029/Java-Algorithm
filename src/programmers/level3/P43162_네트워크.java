package programmers.level3;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class P43162_네트워크 {

	public static void main(String[] args) {
		int n = 3;
		int[][] computers = {{1, 1, 0}, {1, 1, 0}, {0, 0, 1}};
		System.out.println(solution(n, computers));

		int n1 = 3;
		int[][] computers1 = {{1, 1, 0}, {1, 1, 1}, {0, 1, 1}};
		System.out.println(solution(n1, computers1));
	}

	public static int solution(int n, int[][] computers) {
		List<Integer>[] adj = new ArrayList[n];
		for (int i = 0; i < adj.length; i++) {
			adj[i] = new ArrayList<>();
		}

		for (int i = 0; i < computers.length; i++) {
			for (int j = 0; j < computers[i].length; j++) {
				if (i != j && computers[i][j] == 1) {
					adj[i].add(j);
				}
			}
		}

		int cnt = 0;
		boolean[] visit = new boolean[n];

		for (int i = 0; i < n; i++) {
			if (!visit[i]) {
				Queue<Integer> queue = new LinkedList<>();
				queue.offer(i);

				while (!queue.isEmpty()) {
					Integer cur = queue.poll();

					if (visit[cur]) {
						continue;
					}
					visit[cur] = true;

					for (Integer com : adj[cur]) {
						if (!visit[com]) {
							queue.add(com);
						}
					}

				}
				cnt++;
			}
		}

		return cnt;
	}
}
