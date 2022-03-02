package baek.silver;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class B5567_결혼식 {

	static ArrayList<Integer>[] adj;
	static boolean[] visit;
	static int[] friend;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int M = sc.nextInt();

		visit = new boolean[N + 1];
		friend = new int[N + 1];
		adj = new ArrayList[N + 1];
		for (int i = 1; i < adj.length; i++) {
			adj[i] = new ArrayList<>();
		}

		for (int i = 1; i <= M; i++) {
			int a = sc.nextInt();
			int b = sc.nextInt();

			adj[a].add(b);
			adj[b].add(a);
		}

		// 학번이 1인 상근이만 bfs 탐색!!
		bfs(1);

		int cnt = 0;
		for (int i = 0; i < friend.length; i++) {
            if (friend[i] == 1 || friend[i] == 2) {
                cnt++;
            }
		}
		System.out.println(cnt);
	}

	private static void bfs(int start) {
		Queue<Integer> Q = new LinkedList<>();
		Q.add(start);
		visit[start] = true;

		while (!Q.isEmpty()) {
			Integer p = Q.poll();
			int size = adj[p].size();
			for (int i = 0; i < size; i++) {
				Integer q = adj[p].get(i);
				if (!visit[q]) {
					Q.add(q);
					visit[q] = true;
					friend[q] = friend[p] + 1;
				}
			}
		}
	}
}
