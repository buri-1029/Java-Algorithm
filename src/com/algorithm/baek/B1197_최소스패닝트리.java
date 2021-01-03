package com.algorithm.baek;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

/** 
 * 최소 스패닝 트리 크루스칼 알고리즘 
 * 
 */
public class B1197_최소스패닝트리 {
	static int[] parents;
	static class Edge implements Comparable<Edge> {
		int s, e, c;

		Edge(int s, int e, int c) {
			this.s = s;
			this.e = e;
			this.c = c;
		}

		@Override
		public int compareTo(Edge e) {
			// TODO Auto-generated method stub
			if (this.c < e.c) {
				return -1;
			} else if (this.c > e.c) {
				return 1;
			}
			return 0;
		}
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int V = sc.nextInt(); // 정점의 개수
		int E = sc.nextInt(); // 간선의 개수

		ArrayList<Edge> edges = new ArrayList<>();
		parents = new int[V+1];

		for (int i = 0; i < E; i++) {
			int A = sc.nextInt();
			int B = sc.nextInt();
			int C = sc.nextInt(); // 가중치
			edges.add(new Edge(A, B, C));
		}
		Collections.sort(edges);

		// makeset
		for (int i = 0; i < V; i++) {
			parents[i] = i;
		}

		int sum = 0;
		int cnt = 0;
		
		// 간선만큼 돌면서 싸이클이 아니면 더하고 부모 병합
		for (int i = 0; i < E; i++) {
			Edge edge = edges.get(i);
			if (find(edge.s) != find(edge.e)) {
				sum += edge.c;
				union(edge.s, edge.e);
				cnt++;
				if (cnt == V - 1) {
					break;
				}
			}
		}
		System.out.println(sum);
	}

	/** 서로소 집합 */
	private static void union(int x, int y) {
		int px = find(x);
		int py = find(y);
		if (px >= py)
			parents[px] = py;
		else
			parents[py] = px;
	}

	private static int find(int x) {
		if (parents[x] == x) {
			return parents[x];
		} else {
			return find(parents[x]);
		}
	}
}
