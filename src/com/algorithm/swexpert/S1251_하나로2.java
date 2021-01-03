package com.algorithm.swexpert;

import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.Scanner;

public class S1251_하나로2 {
	static int N; // 섬의 개수
	static double E; // 환경 부담 세율 실수
	static ArrayList<Integer> island_x;
	static ArrayList<Integer> island_y;
	static ArrayList<Edge>[] adj;

	static class Edge implements Comparable<Edge> {
		int idx;
		double w;

		public Edge(int idx, double w) {
			super();
			this.idx = idx;
			this.w = w;
		}

		// weight 기준으로 sort
		public int compareTo(Edge o) {
			if (this.w < o.w) {
				return -1;
			} else if (this.w > o.w) {
				return 1;
			}
			return 0;
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();

		for (int tc = 1; tc <= T; tc++) {
			N = sc.nextInt();

			island_x = new ArrayList<>();
			island_y = new ArrayList<>();
			double ANS = 0.0; // 테케마다 초기화

			for (int i = 0; i < N; i++) {
				island_x.add(sc.nextInt());
			}
			for (int i = 0; i < N; i++) {
				island_y.add(sc.nextInt());
			}
			E = sc.nextDouble();

			// 간선리스트 -> 모든 좌표들 거리(가중치)
			ArrayList<Edge>[] adj = new ArrayList[N];
			for (int i = 0; i < N; i++) { // 초기화
				adj[i] = new ArrayList<>();
			}

			/** ***** */
			for (int i = 0; i < N - 1; i++) {
				for (int j = i + 1; j < N; j++) {
					// 환경 부담 세율(E)과 각 해저터널 길이(L)의 제곱의 곱(E * L^2)만큼 지불
					double L = Math.sqrt(Math.pow(island_x.get(i) - island_x.get(j), 2)
							+ Math.pow(island_y.get(i) - island_y.get(j), 2));
					double w = (E * Math.pow(L, 2));

					// 리스트에 저장 (섬 배열의 i인덱스가 x좌표 , j인덱스가 y좌표라, w)
					adj[i].add(new Edge(j, w));
					adj[j].add(new Edge(i, w));
				}
			}
			// 방문했는지 확인하기 위한 boolean 배열
			boolean[] visited = new boolean[N];
			visited[0] = true;

			PriorityQueue<Edge> pq = new PriorityQueue<>();
			pq.addAll(adj[0]);

			int cnt = 1;
			while (cnt < N) {
				Edge e = pq.poll();

				if (!visited[e.idx]) {
					visited[e.idx] = true;
					ANS += e.w; // 가중치 증가
					pq.addAll(adj[e.idx]);
					cnt++;
				}
			}
			System.out.printf("#%d %.0f\n", tc, ANS);
		}
	}
}
