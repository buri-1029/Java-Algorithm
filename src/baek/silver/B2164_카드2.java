package baek.silver;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class B2164_카드2 {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int N = scan.nextInt();

		Queue<Integer> card = new LinkedList<>();
		for (int i = 1; i <= N; i++) {
			card.add(i);
		}

		int order = 0;

		while (card.size() != 1) {
			if (order % 2 == 0) {
				card.poll();
			} else {
				Integer cur = card.poll();
				card.add(cur);
			}

			order++;
		}

		System.out.println(card.peek());
	}
}
