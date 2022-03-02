package baek.silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/**
 * 인접리스트를 이용한 DFS와 BFS
 */
public class B1260_DFS와BFS {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int V = Integer.parseInt(st.nextToken());
		boolean[] visit = new boolean[N + 1];

		// 각 adj에 연결된 노드의 정보가 들어간다. (초기화를 하여 생성하지 않으면 오류 발생)
		ArrayList<Integer>[] adj = new ArrayList[N + 1];
		for (int i = 1; i < adj.length; i++) {
			adj[i] = new ArrayList<>();
		}

		for (int i = 1; i <= M; i++) {
			st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());

			adj[x].add(y); // 양방향 그래프이기 때문에
			adj[y].add(x); // 서로 연결되어 있다고 표시
		}

		// 방문할 수 있는 정점이 여러 개인 경우에는 정점 번호가 작은 것을 먼저 방문하므로 오름차순으로 정렬
		for (int i = 1; i < adj.length; i++) {
			Collections.sort(adj[i]);
		}

		dfs(adj, V, visit);
		System.out.println();
		bfs(adj, V);
	}

	private static void dfs(ArrayList<Integer>[] adj, int n, boolean[] v) {
		v[n] = true;
		System.out.print(n + " ");
		int size = adj[n].size();
		for (int i = 0; i < size; i++) {
			Integer nn = adj[n].get(i);
			if (!v[nn]) {
				dfs(adj, nn, v);
			}
		}
	}

	private static void bfs(ArrayList<Integer>[] adj, int start) {
		boolean[] v = new boolean[adj.length];
		Queue<Integer> Q = new LinkedList<Integer>();
		Q.add(start);
		v[start] = true;

		while (!Q.isEmpty()) {
			Integer p = Q.poll();
			System.out.print(p + " ");
			int size = adj[p].size();
			for (int i = 0; i < size; i++) {
				Integer nn = adj[p].get(i);
				if (!v[nn]) {
					Q.add(nn);
					v[nn] = true;
				}
			}
		}
	}
}
