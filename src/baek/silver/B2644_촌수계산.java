package baek.silver;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class B2644_촌수계산 {

	static int n, a, b;
	static int ans;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		a = sc.nextInt();
		b = sc.nextInt();

		boolean[] visit = new boolean[n + 1];
		ArrayList<Integer>[] adj = new ArrayList[n + 1];
		for (int i = 1; i < adj.length; i++) {
			adj[i] = new ArrayList<>();
		}

		int m = sc.nextInt();
		for (int i = 0; i < m; i++) {
			int x = sc.nextInt();
			int y = sc.nextInt();
			adj[x].add(y);
			adj[y].add(x);
		}

		bfs(adj, visit);
		if (visit[b]) {
			System.out.println(ans);
		} else {
			System.out.println(-1);
		}

	}

	private static void bfs(ArrayList<Integer>[] adj, boolean[] visit) {
		Queue<Point> queue = new LinkedList<>();
		queue.add(new Point(a, 0));
		visit[a] = true;

		while (!queue.isEmpty()) {
			Point cur = queue.poll();
			//System.out.println(cur.n + " " + cur.cnt);
			if (cur.n == b) {
				ans = cur.cnt;
				break;
			}
			int size = adj[cur.n].size();
			for (int i = 0; i < size; i++) {
				int next = adj[cur.n].get(i);
				if (!visit[next]) {
					queue.add(new Point(next, cur.cnt + 1));
					visit[next] = true;
				}
			}
		}
	}

	static class Point {

		int n, cnt;

		public Point(int n, int cnt) {
			super();
			this.n = n;
			this.cnt = cnt;
		}
	}
}
