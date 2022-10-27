package baek.silver;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class B16953_AB {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		long A = sc.nextInt();
		long B = sc.nextInt();

		Queue<Number> queue = new LinkedList<>();
		queue.add(new Number(A, 1));

		while (!queue.isEmpty()) {
			Number now = queue.poll();

			if (now.num == B) {
				System.out.println(now.cnt);
				return;
			}

			if (2 * now.num <= B) {
				queue.add(new Number(2 * now.num, now.cnt + 1));
			}
			if (10 * now.num + 1 <= B) {
				queue.add(new Number(10 * now.num + 1, now.cnt + 1));
			}
		}
		System.out.println(-1);
	}

	static class Number {

		long num;
		int cnt;

		public Number(long num, int cnt) {
			this.num = num;
			this.cnt = cnt;
		}
	}

}
