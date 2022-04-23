package baek.silver;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Scanner;

public class B11725_트리의부모찾기 {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int N = scan.nextInt();

		List<Integer>[] adj = new ArrayList[N + 1];
		for (int i = 1; i < adj.length; i++) {
			adj[i] = new ArrayList<>();
		}

		for (int i = 0; i < N - 1; i++) {
			int a = scan.nextInt();
			int b = scan.nextInt();

			adj[a].add(b);
			adj[b].add(a);
		}

		boolean visited[] = new boolean[N + 1];
		Queue<Integer> queue = new LinkedList<>();
		queue.add(1);
		visited[1] = true;

		int[] answer = new int[N + 1];

		while (!queue.isEmpty()) {
			Integer cur = queue.poll();

			for (Integer i : adj[cur]) {
				if (!visited[i]) {
					visited[i] = true;
					answer[i] = cur;
					queue.add(i);
				}
			}
		}

		for (int i = 2; i < answer.length; i++) {
			System.out.println(answer[i]);
		}
	}
}
