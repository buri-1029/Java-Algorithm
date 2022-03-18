package programmers.level2;

import java.util.LinkedList;
import java.util.Queue;

public class P42583_다리를지나는트럭 {

	public static void main(String[] args) {
		int bridge_length = 2;
		int weight = 10;
		int[] truck_weights = {7, 4, 5, 6};

		System.out.println(solution(bridge_length, weight, truck_weights));
	}

	private static int solution(int bridge_length, int weight, int[] truck_weights) {
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
				} else if (queue.size() == bridge_length) {
					sum -= queue.poll();
				} else {
					if (sum + truck <= weight) {
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

		return time + bridge_length;
	}

}
