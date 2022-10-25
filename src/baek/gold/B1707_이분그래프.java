package baek.gold;

import java.util.ArrayList;
import java.util.Scanner;

public class B1707_이분그래프 {

	public static ArrayList<Integer>[] adj;
	public static int[] visited;
	public static boolean result;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int K = sc.nextInt();

		for (int k = 0; k < K; k++) {
			int V = sc.nextInt();
			int E = sc.nextInt();

			adj = new ArrayList[V + 1];
			for (int i = 1; i < adj.length; i++) {
				adj[i] = new ArrayList<>();
			}

			visited = new int[V + 1];
			result = false;

			for (int i = 0; i < E; i++) {
				int u = sc.nextInt();
				int v = sc.nextInt();

				adj[u].add(v);
				adj[v].add(u);
			}

			for (int i = 1; i <= V; i++) {
				if (visited[i] == 0) {
					dfs(i, 1);
				}
			}

			if (result) {
				System.out.println("NO");
			} else {
				System.out.println("YES");
			}


		}
	}

	private static void dfs(int idx, int j) {
		visited[idx] = j;

		if (result) {
			return;
		}

		for (Integer i : adj[idx]) {
			if (visited[i] == visited[idx]) {
				result = true;
				return;
			}

			if (visited[i] == 0) {
				dfs(i, j * -1);
			}
		}
	}

}
