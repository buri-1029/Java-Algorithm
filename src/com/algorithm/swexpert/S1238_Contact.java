package com.algorithm.swexpert;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/** 스터티 친구 도움 받았음. */
public class S1238_Contact {
	static int N, S, from, to;
	static int last = Integer.MIN_VALUE, res = 0;
	static int[][] adj;

	static class Point {
		int node;
		int call; //연락 받은 순서

		public Point(int node, int call) {
			super();
			this.node = node;
			this.call = call;
		}
	}

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		for (int tc = 1; tc <= 10; tc++) {
			last = 0;
			res = 0;
			StringTokenizer st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			S = Integer.parseInt(st.nextToken());

			adj = new int[101][101];

			StringTokenizer st1 = new StringTokenizer(br.readLine());
			for (int n = 0; n < N / 2; n++) {
				from = Integer.parseInt(st1.nextToken());
				to = Integer.parseInt(st1.nextToken());
				adj[from][to] = 1;
			}

			bfs(S);
			System.out.println("#" + tc + " " + res);
		}
	}

	private static void bfs(int start) {
		// TODO Auto-generated method stub
		boolean v[] = new boolean[N + 1];
		Queue<Point> Q = new LinkedList<>();
		Q.add(new Point(start, 0));
		v[start] = true;
		
		while (!Q.isEmpty()) {
			Point p = Q.poll();
			for (int i = 0; i < adj.length; i++) {
				if (adj[p.node][i] == 1 && !v[i]) {
					//연락받은 순서는 1씩 증가하면서 추가
					Q.add(new Point(i, p.call + 1));
					v[i] = true;
				}
			}
			
			// 노드의 연락받은 순서가 마지막인가 확인
			if (p.call == last) { 
				// 같으면 res는 노드 중 가장 큰 값으로,
				res = Math.max(res, p.node);
				
			// 노드의 연락받은 순서가 지금까지 저장된 last(마지막)보다 크면
			} else if (p.call > last) { 
				last = p.call; // last에 저장,
				res = p.node;  // res는 그 노드로 저장,
			}
		}
	}
}
