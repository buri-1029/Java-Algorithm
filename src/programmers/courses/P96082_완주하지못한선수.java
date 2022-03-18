package programmers.courses;

import java.util.HashMap;
import java.util.Map;

public class P96082_완주하지못한선수 {

	public static void main(String[] args) {
		String[] participant1 = {"leo", "kiki", "eden"};
		String[] completion1 = {"eden", "kiki"};

		String answer1 = solution(participant1, completion1);
		System.out.println(answer1);

		String[] participant2 = {"mislav", "stanko", "mislav", "ana"};
		String[] completion2 = {"stanko", "ana", "mislav"};

		String answer2 = solution(participant2, completion2);
		System.out.println(answer2);
	}

	public static String solution(String[] participant, String[] completion) {
		Map<String, Integer> map = new HashMap<>();

		for (String p : participant) {
			map.put(p, map.getOrDefault(p, 0) + 1);
		}

		for (String c : completion) {
			map.put(c, map.get(c) - 1);
		}

		return map.keySet()
				  .stream()
				  .filter(key -> map.get(key) > 0)
				  .findFirst()
				  .get();
	}
}
