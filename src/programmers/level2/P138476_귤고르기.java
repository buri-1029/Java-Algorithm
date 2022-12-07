package programmers.level2;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class P138476_귤고르기 {

	public static void main(String[] args) {
		int k = 6;
		int[] tangerine = {1, 3, 2, 5, 4, 5, 2, 3};
		System.out.println(solution(k, tangerine));
	}

	public static int solution(int k, int[] tangerine) {
		int answer = 0;

		Map<Integer, Integer> map = new HashMap<>();

		for (int i : tangerine) {
			map.put(i, map.getOrDefault(i, 0) + 1);
		}

		List<Integer> keySet = new ArrayList<>(map.keySet());

		keySet.sort((o1, o2) -> map.get(o2)
								   .compareTo(map.get(o1)));

		int idx = 0;
		while (k > 0) {
			k -= map.get(keySet.get(idx));
			answer++;
			idx++;
		}

		return answer;
	}
}
