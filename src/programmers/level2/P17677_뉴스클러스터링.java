package programmers.level2;

import java.util.HashMap;
import java.util.Map;

public class P17677_뉴스클러스터링 {

	public static void main(String[] args) {
		String str1 = "FRANCE";
		String str2 = "french";

		String str3 = "aa1+aa2";
		String str4 = "AAAA12";

		System.out.println(solution(str1, str2));
		System.out.println(solution(str3, str4));

	}

	public static int solution(String str1, String str2) {

		int num = 65536;

		str1 = str1.toLowerCase();
		str2 = str2.toLowerCase();

		if (str1.equals(str2)) {
			return num;
		}

		Map<String, Integer> map1 = new HashMap<>();
		Map<String, Integer> map2 = new HashMap<>();

		for (int i = 0; i < str1.length() - 1; i++) {
			String s = str1.substring(i, i + 2);

			if (!s.matches("^[a-zA-Z]*$")) {
				continue;
			}

			map1.put(s, map1.containsKey(s) ? map1.get(s) + 1 : 1);
		}

		for (int i = 0; i < str2.length() - 1; i++) {
			String s = str2.substring(i, i + 2);

			if (!s.matches("^[a-zA-Z]*$")) {
				continue;
			}

			map2.put(s, map2.containsKey(s) ? map2.get(s) + 1 : 1);
		}

		int union = map1.values()
						.stream()
						.reduce(0, Integer::sum)
			+ map2.values()
				  .stream()
				  .reduce(0, Integer::sum);

		int intersection = 0;

		for (String s : map1.keySet()) {
			if (map2.containsKey(s)) {
				intersection += Math.min(map1.get(s), map2.get(s));
			}
		}

		union -= intersection;

		return (int) ((float) intersection / union * 65536);
	}
}
