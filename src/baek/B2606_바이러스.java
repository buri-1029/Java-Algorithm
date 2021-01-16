package baek;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class B2606_바이러스 {
	static int cnt = 0;
	static boolean[] visit;
	static ArrayList<Integer>[] network;

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int com = sc.nextInt(); // 컴퓨터의 수(정점의 수)
		int link = sc.nextInt(); // 연결된 수(간선의 수)

		network = new ArrayList[com + 1];
		visit = new boolean[com + 1];

		for (int i = 1; i < network.length; i++) {
			network[i] = new ArrayList<>();
		}

		for (int i = 1; i <= link; i++) {
			int a = sc.nextInt();
			int b = sc.nextInt();

			network[a].add(b); // 무향 그래프이기 때문에
			network[b].add(a); // 서로 인접리스트로 추가
		}

		dfs(1);
		System.out.println(cnt);
		// bfs(1);
		// System.out.println(cnt);
	}

	private static void dfs(int idx) {
		// TODO Auto-generated method stub
		visit[idx] = true;
		int size = network[idx].size();

		for (int i = 0; i < size; i++) {
			Integer N = network[idx].get(i); 
			if (!visit[N]) {
				cnt++;
				dfs(N);
			}
		}
	}

	private static void bfs(int start) {
		boolean[] v = new boolean[network.length];
		Queue<Integer> Q = new LinkedList<Integer>();
		Q.add(start);
		v[start] = true;

		while (!Q.isEmpty()) {
			Integer p = Q.poll();
			int size = network[p].size();
			for (int i = 0; i < size; i++) {
				Integer N = network[p].get(i);
				if (!v[N]) {
					cnt++;
					Q.add(N);
					v[N] = true;
				}
			}
		}
	}
}