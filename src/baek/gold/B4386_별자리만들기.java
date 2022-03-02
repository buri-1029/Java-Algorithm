package baek.gold;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class B4386_별자리만들기 {

	static int N;
	static double ANS = 0.0;
	static Point[] star;
	static int[] parents;

	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		star = new Point[N]; // 좌표 저장하기 위한 배열

		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			double x = Double.parseDouble(st.nextToken());
			double y = Double.parseDouble(st.nextToken());
			star[i] = new Point(x, y);
		}

		ArrayList<Edge> list = new ArrayList<>();
		parents = new int[N];

		for (int i = 0; i < N - 1; i++) {
			for (int j = i + 1; j < N; j++) {
				double dist = Math.sqrt(
					Math.pow(star[i].x - star[j].x, 2) + Math.pow(star[i].y - star[j].y, 2));
				list.add(new Edge(i, j, dist));
			}
		}

		Collections.sort(list);

		// makeSet
		for (int i = 0; i < N; i++) {
			parents[i] = i;
		}

		for (int i = 0; i < list.size(); i++) {
			Edge edge = list.get(i);
			if (find(edge.s) != find(edge.e)) {
				ANS += edge.d;
				union(edge.s, edge.e);
			}
		}
		System.out.println(ANS);
	}

	private static void union(int x, int y) {
		int px = find(x);
		int py = find(y);
		if (px >= py) {
			parents[px] = py;
		} else {
			parents[py] = px;
		}
	}

	private static int find(int x) {
		if (parents[x] == x) {
			return parents[x];
		} else {
			return find(parents[x]);
		}
	}

	static class Point { // x, y좌표 Point 클래스

		double x, y;

		public Point(double x, double y) {
			super();
			this.x = x;
			this.y = y;
		}
	}

	static class Edge implements Comparable<Edge> {

		int s;
		int e;
		double d; // 거리

		public Edge(int s, int e, double d) {
			super();
			this.s = s;
			this.e = e;
			this.d = d;
		}

		@Override
		public int compareTo(Edge e) {
			// TODO Auto-generated method stub
			if (this.d < e.d) {
				return -1;
			} else if (this.d > e.d) {
				return 1;
			}
			return 0;
		}

	}
}