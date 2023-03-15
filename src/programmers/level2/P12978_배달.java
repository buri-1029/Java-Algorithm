package programmers.level2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;

public class P12978_배달 {

	static final int INFINITY = Integer.MAX_VALUE;
	static List<Vertex>[] list;
	static int[] dist;
	static boolean[] visited;

	// 다익스트라 알고리즘
	public static int solution2(int N, int[][] road, int K) {
		list = new ArrayList[N + 1];
		for (int i = 0; i <= N; i++) {
			list[i] = new ArrayList<>();
		}

		dist = new int[N + 1];
		visited = new boolean[N + 1];

		Arrays.fill(dist, INFINITY);

		for (int i = 0; i < road.length; i++) {
			int u = road[i][0];
			int v = road[i][1];
			int w = road[i][2];

			list[u].add(new Vertex(v, w));
			list[v].add(new Vertex(u, w));
		}

		dijkstra(1);

		return (int) Arrays.stream(dist)
						   .filter(value -> K >= value)
						   .count();
	}

	private static void dijkstra(int start) {
		dist[start] = 0;
		PriorityQueue<Vertex> pq = new PriorityQueue<>();
		pq.offer(new Vertex(start, dist[start]));

		while (!pq.isEmpty()) {
			Vertex cur = pq.poll();

			if (visited[cur.v]) {
				continue;
			}
			visited[cur.v] = true;

			for (Vertex vertex : list[cur.v]) {
				if (dist[vertex.v] > dist[cur.v] + vertex.w) {
					dist[vertex.v] = dist[cur.v] + vertex.w;
					pq.offer(new Vertex(vertex.v, dist[vertex.v]));
				}
			}
		}
	}

	// 플로이드 와샬 알고리즘
	public static int solution1(int N, int[][] road, int K) {
		int answer = 0;
		int[][] map = new int[N][N];

		for (int i = 0; i < map.length; i++) {
			for (int j = 0; j < map.length; j++) {
				if (i == j) {
					map[i][j] = 0;
					continue;
				}

				map[i][j] = 500001;
			}
		}

		for (int[] arr : road) {
			if (map[arr[0] - 1][arr[1] - 1] < arr[2]) {
				continue;
			}

			map[arr[0] - 1][arr[1] - 1] = arr[2];
			map[arr[1] - 1][arr[0] - 1] = arr[2];
		}

		for (int k = 0; k < N; k++) {
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					if (map[i][j] > map[i][k] + map[k][j]) {
						map[i][j] = map[i][k] + map[k][j];
					}
				}
			}
		}

		for (int i = 0; i < map.length; i++) {
			if (map[0][i] <= K) {
				answer++;
			}
		}

		return answer;
	}

	public static void main(String[] args) {
		int N = 5;
		int[][] road = {{1, 2, 1}, {2, 3, 3}, {5, 2, 2}, {1, 4, 2}, {5, 3, 1}, {5, 4, 2}};
		int K = 3;
		// System.out.println(solution1(N, road, K));
		System.out.println(solution2(N, road, K));
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
