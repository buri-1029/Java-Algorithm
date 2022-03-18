package programmers.level2;

import java.util.HashMap;
import java.util.Map;

public class P42578_위장 {

	public static void main(String[] args) {
		String[][] clothes1 = {{"yellowhat", "headgear"},
			{"bluesunglasses", "eyewear"},
			{"green_turban", "headgear"}};

		String[][] clothes2 = {{"crowmask", "face"},
			{"bluesunglasses", "face"},
			{"smoky_makeup", "face"}};

		System.out.println(solution(clothes1));
		System.out.println(solution(clothes2));
	}

	private static int solution(String[][] clothes) {
		Map<String, Integer> map = new HashMap<>();

		for (int i = 0; i < clothes.length; i++) {
			map.put(clothes[i][1], map.getOrDefault(clothes[i][1], 0) + 1);
		}

		int answer = 1;

		if (map.size() > 1) {
			for (String key : map.keySet()) {
				// 안 입는 경우 더하기
				answer *= map.get(key) + 1;
			}
			answer--;
		} else {
			answer = clothes.length;
		}

		return answer;
	}
}
