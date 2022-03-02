package baek.gold;

import java.util.ArrayList;
import java.util.Scanner;


public class B17471_게리멘더링 {

	static int N, res = Integer.MAX_VALUE;
	static int[] people;
	static boolean[] select;
	static ArrayList<Integer>[] adj;
	static boolean[] visit;

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();

		people = new int[N + 1];
		select = new boolean[N + 1];

		adj = new ArrayList[N + 1];
		for (int i = 1; i <= N; i++) {
			adj[i] = new ArrayList<>();
		}

		for (int i = 1; i <= N; i++) {
			people[i] = sc.nextInt();
		}

		for (int i = 1; i <= N; i++) {
			int cnt = sc.nextInt();

			for (int j = 0; j < cnt; j++) {
				int n = sc.nextInt();
				adj[i].add(n);
			}
		}

		powerset(1, 0, 0);
		if (res != Integer.MAX_VALUE) {
			System.out.println(res);
		} else {
			System.out.println(-1);
		}
	}

	private static void powerset(int idx, int p1, int p2) {
		if (idx == N + 1) {
			int c1 = 0;
			int c2 = 0;
			visit = new boolean[N + 1];
			for (int i = 1; i <= N; i++) {
				if (select[i] && !visit[i]) {
					dfs(i, true);
					c1++;
				} else if (!select[i] && !visit[i]) {
					dfs(i, false);
					c2++;
				}
			}
			if (c1 + c2 == 2) {
				int gap = Math.abs(p1 - p2);
				res = Math.min(gap, res);
			}
			return;
		}
		select[idx] = true;
		powerset(idx + 1, p1 + people[idx], p2);

		select[idx] = false;
		powerset(idx + 1, p1, p2 + people[idx]);
	}

	private static void dfs(int idx, boolean flag) {
		// TODO Auto-generated method stub
		visit[idx] = true;
		for (int j = 0; j < adj[idx].size(); j++) {
			Integer n = adj[idx].get(j);
			if (!visit[n] && select[n] == flag) {
				dfs(n, flag);
			}
		}
	}
}
