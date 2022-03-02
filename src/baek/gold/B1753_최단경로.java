package baek.gold;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

/**
 * Dijkstra : 시작 정점에서 거리가 최소인 정점을 선택해 나가면서 최단 경로를 구하는 방식
 */
public class B1753_최단경로 {

	static final int INFINITY = Integer.MAX_VALUE;
	static List<Vertex>[] list;
	static int[] dist;
	static boolean[] visited;

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(in.readLine(), " ");

		int V = Integer.parseInt(st.nextToken()); // 정점의 개수
		int E = Integer.parseInt(st.nextToken()); // 간선의 개수
		int K = Integer.parseInt(in.readLine()); // 시작 정점

		list = new ArrayList[V + 1];
		for (int i = 0; i <= V; i++) {
			list[i] = new ArrayList<>();
		}

		dist = new int[V + 1];
		visited = new boolean[V + 1];

		Arrays.fill(dist, INFINITY); // dist 값 무한대로 초기화

		for (int i = 0; i < E; i++) {
			st = new StringTokenizer(in.readLine(), " ");
			int u = Integer.parseInt(st.nextToken());
			int v = Integer.parseInt(st.nextToken());
			int w = Integer.parseInt(st.nextToken());
			// u에서 v로 가는 가중치 w
			list[u].add(new Vertex(v, w));
		}

		dijkstra(K);

		for (int i = 1; i <= V; i++) {
			if (dist[i] == INFINITY) {
				System.out.println("INF");
			} else {
				System.out.println(dist[i]);
			}
		}
	}

	private static void dijkstra(int k) {
		dist[k] = 0; // 시작정점에서 자신으로 가는 거리는 0
		PriorityQueue<Vertex> pQueue = new PriorityQueue<Vertex>();
		pQueue.offer(new Vertex(k, dist[k]));

		while (!pQueue.isEmpty()) {
			Vertex cur = pQueue.poll(); // dist가 최소인 정점 poll()

			if (visited[cur.v]) {
				continue;
			}
			visited[cur.v] = true;

			for (Vertex vertex : list[cur.v]) {
				// 거리 값 + 현재 정점에서 방문하지 않은 정점까지의 가중치 합이 작다면 변경
				if (dist[vertex.v] > dist[cur.v] + vertex.w) {
					dist[vertex.v] = dist[cur.v] + vertex.w;
					pQueue.add(new Vertex(vertex.v, dist[vertex.v]));
				}
			}
		}
	}

	static class Vertex implements Comparable<Vertex> {

		int v, w;

		public Vertex(int v, int w) {
			super();
			this.v = v;
			this.w = w;
		}

		@Override
		public int compareTo(Vertex o) {
			return this.w - o.w;
		}
	}
}
