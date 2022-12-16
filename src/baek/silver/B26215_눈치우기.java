package baek.silver;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Scanner;

public class B26215_눈치우기 {

	static final int MAX_MINUTE = 1440;

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int N = scan.nextInt();

		PriorityQueue<Integer> pq = new PriorityQueue<>(Comparator.reverseOrder());
		for (int i = 0; i < N; i++) {
			pq.add(scan.nextInt());
		}

		int minute = 0;

		while (!pq.isEmpty()) {
			if (minute > MAX_MINUTE) {
				break;
			}

			if (pq.size() > 1) {
				int snow1 = pq.poll();
				int snow2 = pq.poll();

				if (snow1 - 1 != 0) {
					pq.add(snow1 - 1);
				}

				if (snow2 - 1 != 0) {
					pq.add(snow2 - 1);
				}
			} else {
				int snow = pq.poll();
				if (snow - 1 != 0) {
					pq.add(snow - 1);
				}
			}

			minute++;
		}

		System.out.println(minute > MAX_MINUTE ? -1 : minute);
	}
}
