package com.algorithm.baek;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Scanner;
/* 
 *	다익스트라 이용
 */
public class B1504_특정한최단경로 {
	static final int INF = 200000000;
	static int N, E, v1, v2, d1, d2, Ans;
	static ArrayList<Vertex>[] list;
	static int[] dist;

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
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		E = sc.nextInt();

		list = new ArrayList[N + 1];
		for (int i = 1; i < N + 1; i++) {
			list[i] = new ArrayList<>();
		}

		for (int i = 0; i < E; i++) {
			int a = sc.nextInt();
			int b = sc.nextInt();
			int c = sc.nextInt();

			list[a].add(new Vertex(b, c));
			list[b].add(new Vertex(a, c));
		}
		v1 = sc.nextInt();
		v2 = sc.nextInt();
		
		dijkstra(1);
		d1 += dist[v1];
		d2 += dist[v2];
		dijkstra(v1);
		d1 += dist[v2];
		d2 += dist[N];
		dijkstra(v2);
		d1 += dist[N];
		d2 += dist[v1];
		
		if(d1 >= INF && d2 >= INF) Ans = -1;
		else Ans = Math.min(d1, d2);
		
		System.out.println(Ans);
	}

	private static void dijkstra(int k) {
		dist = new int[N + 1];
		Arrays.fill(dist, INF); // dist 값 무한대로 초기화
		
		dist[k] = 0;
		PriorityQueue<Vertex> pQueue = new PriorityQueue<Vertex>();
		pQueue.offer(new Vertex(k, dist[k]));
		
		while (!pQueue.isEmpty()) {
			Vertex cur = pQueue.poll(); // dist가 최소인 정점 poll()
			
			if(cur.v == N) Ans = Math.min(Ans, dist[cur.v] + cur.w);
				

			for (Vertex vertex : list[cur.v]) {
				// 거리 값 + 현재 정점에서 방문하지 않은 정점까지의 가중치 합이 작다면 변경
				if (dist[vertex.v] > dist[cur.v] + vertex.w) {
					dist[vertex.v] = dist[cur.v] + vertex.w;
					pQueue.add(new Vertex(vertex.v, dist[vertex.v]));
				}
			}
		}	
	}
}
