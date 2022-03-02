package baek.silver;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class B11724_연결요소의개수 {

	static int res;
	static ArrayList<Integer>[] adj;
	static boolean[] visit;

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt(); // 정점 수
		int M = sc.nextInt(); // 간선 수

		visit = new boolean[N + 1];
		adj = new ArrayList[N + 1];
		for (int i = 1; i < N + 1; i++) {
			adj[i] = new ArrayList<>();
		}

		for (int i = 0; i < M; i++) {
			int u = sc.nextInt();
			int v = sc.nextInt();
			adj[u].add(v);
			adj[v].add(u);
		}

		for (int i = 1; i < N + 1; i++) {
			if (!visit[i]) {
				bfs(i);
				res++;
			}
		}
		System.out.println(res);
	}

	private static void bfs(int idx) {
		Queue<Integer> queue = new LinkedList<>();
		queue.add(idx);
		visit[idx] = true;

		while (!queue.isEmpty()) {
			Integer cur = queue.poll();
			int size = adj[cur].size();
			for (int i = 0; i < size; i++) {
				Integer n = adj[cur].get(i);
				if (!visit[n]) {
					queue.add(n);
					visit[n] = true;
				}
			}
		}
	}
}
