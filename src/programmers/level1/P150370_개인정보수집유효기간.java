package programmers.level1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class P150370_개인정보수집유효기간 {

	public static void main(String[] args) {
		String today = "2022.05.19";
		String[] terms = {"A 6", "B 12", "C 3"};
		String[] privacies = {"2021.05.02 A", "2021.07.01 B", "2022.02.19 C", "2022.02.20 C"};

		System.out.println(Arrays.toString(solution(today, terms, privacies)));

	}

	public static int[] solution(String today, String[] terms, String[] privacies) {
		List<Integer> answer = new ArrayList<>();

		String[] today_temp = today.split("\\.");
		int cnt = Integer.parseInt(today_temp[0]) * 12 * 28
			+ Integer.parseInt(today_temp[1]) * 28
			+ Integer.parseInt(today_temp[2]);

		Map<String, Integer> map = new HashMap<>();
		for (String i : terms) {
			String[] a = i.split("\\s");
			map.put(a[0], Integer.parseInt(a[1]));
		}

		for (int i = 0; i < privacies.length; i++) {
			int year = Integer.parseInt(privacies[i].substring(0, 4));
			int month = Integer.parseInt(privacies[i].substring(5, 7));
			int day = Integer.parseInt(privacies[i].substring(8, 10));
			String t = privacies[i].substring(11, 12);

			Integer n = map.get(t);
			month += n;

			int temp = year * 12 * 28 + month * 28 + day - 1;

			if (cnt > temp) {
				answer.add(i + 1);
			}
		}

		return answer.stream()
					 .mapToInt(i -> i)
					 .toArray();
	}
}
