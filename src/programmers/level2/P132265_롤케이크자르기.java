package programmers.level2;

import java.util.HashMap;
import java.util.HashSet;

public class P132265_롤케이크자르기 {

	public static void main(String[] args) {
		int[] topping = {1, 2, 1, 3, 1, 4, 1, 2};
		System.out.println(solution(topping));
	}

	public static int solution(int[] topping) {
		int length = topping.length;

		HashSet<Integer> first = new HashSet<>();
		HashMap<Integer, Integer> second = new HashMap<>();

		first.add(topping[0]);

		for (int i = 1; i < length; i++) {
			second.put(topping[i], second.getOrDefault(topping[i], 0) + 1);
		}

		int answer = 0;

		for (int i = 1; i < length; i++) {
			first.add(topping[i]);

			int cnt = second.get(topping[i]);

			if (cnt == 1) {
				second.remove(topping[i]);
			} else {
				second.put(topping[i], cnt - 1);
			}

			if (first.size() == second.size()) {
				answer++;
			}
		}

		return answer;
	}
}
