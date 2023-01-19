package baek.silver;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class B2161_카드1 {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int N = scan.nextInt();

		Queue<Integer> queue = new LinkedList();

		for (int i = 1; i <= N; i++) {
			queue.add(i);
		}

		while (queue.size() != 1) {
			int s = queue.poll();
			System.out.print(s + " ");

			int qu = queue.poll();
			queue.add(qu);
		}

		System.out.print(queue.poll());
	}
}
