package baek.silver;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class B13335_트럭 {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int n = scan.nextInt();
		int w = scan.nextInt();
		int L = scan.nextInt();

		int[] truck_weights = new int[n];
		for (int i = 0; i < n; i++) {
			truck_weights[i] = scan.nextInt();
		}

		Queue<Integer> queue = new LinkedList<>();
		int sum = 0, time = 0;

		for (int i = 0; i < truck_weights.length; i++) {
			int truck = truck_weights[i];
			while (true) {
				if (queue.isEmpty()) {
					queue.add(truck);
					sum += truck;
					time++;
					break;
				} else if (queue.size() == w) {
					sum -= queue.poll();
				} else {
					if (sum + truck <= L) {
						queue.add(truck);
						sum += truck;
						time++;
						break;
					} else {
						queue.add(0);
						time++;
					}
				}
			}
		}

		System.out.println(time + w);
	}
}
