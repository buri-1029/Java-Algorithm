package com.algorithm.baek;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Scanner;

public class B1719_택배 {
	static int n, m;
	static final int INFINITY = Integer.MAX_VALUE;
	static List<Vertex>[] list;
	static int[] dist;
	static boolean[] visited;
	static int[][] ans; // 	지나쳐야하는 정점 저장하는 배열 

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

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		m = sc.nextInt();

		list = new ArrayList[n + 1];
		for (int i = 1; i <= n; i++) {
			list[i] = new ArrayList<>();
		}
		
		// v1 집하장에서 v2 집하장으로 최당경로를 통해 가기 위해서
		// 제일 먼저 이동해야하는 집하장 저장하는 2차원 배열
		ans = new int[n + 1][n + 1];

		for (int i = 0; i < m; i++) {
			int v1 = sc.nextInt();
			int v2 = sc.nextInt();
			int w = sc.nextInt();

			list[v1].add(new Vertex(v2, w));
			list[v2].add(new Vertex(v1, w));

		}
		
		// 모든 정점 탐색
		for (int k = 1; k <= n; k++) {
			// k를 출발하는 정점
			dijkstra(k);
		}
	
		// 경로표 출력
		for (int i = 1; i <= n; i++) {
			for (int j = 1; j <= n; j++) {
				if(i==j) {
					System.out.print("- ");
				}else {
					System.out.print(ans[i][j]+" ");
				}
			}
			System.out.println();
		}
	}
	
	private static void dijkstra(int k) {
		dist = new int[n + 1];
		visited = new boolean[n + 1];
		Arrays.fill(dist, INFINITY);

		dist[k] = 0; 
		PriorityQueue<Vertex> pQueue = new PriorityQueue<Vertex>();
		pQueue.offer(new Vertex(k, dist[k]));

		while (!pQueue.isEmpty()) {
			Vertex cur = pQueue.poll(); 

			if (visited[cur.v])
				continue;
			visited[cur.v] = true;

			for (Vertex vertex : list[cur.v]) {
				
				if (dist[vertex.v] > dist[cur.v] + vertex.w) {
					dist[vertex.v] = dist[cur.v] + vertex.w;
					ans[vertex.v][k] = cur.v; //[k와 인접한 정점][출발정점 : k] = 지나쳐야하는 즉, 현재 정점
					pQueue.add(new Vertex(vertex.v, dist[vertex.v]));
				}
			}
		}
	}
}