package baek.silver;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class B1021_회전하는큐 {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int N = scan.nextInt();
		int M = scan.nextInt();

		Queue<Integer> queue = new LinkedList<>();
		Queue<Integer> find = new LinkedList<>();
		int ans = 0;

		for (int i = 1; i <= N; i++) {
			queue.add(i);
		}

		for (int i = 0; i < M; i++) {
			int x = scan.nextInt();
			find.add(x);
		}

		while (!find.isEmpty()) {
			int tmp = find.poll();
			int cnt = 0;

			while (tmp != queue.peek()) {
				int q = queue.poll();
				queue.add(q);
				cnt++;
			}

			ans += Math.min(cnt, queue.size() - cnt);
			queue.poll();
		}

		System.out.println(ans);
	}
}
