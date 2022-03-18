package programmers.level1;

import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

public class P02334_신고결과받기 {

	public static void main(String[] args) {
		String[] id_list = {"muzi", "frodo", "apeach", "neo"};
		String[] report = {"muzi frodo", "apeach frodo", "frodo neo", "muzi neo", "apeach muzi"};
		int k = 2;
		System.out.println(Arrays.toString(solution(id_list, report, k)));

		String[] id_list1 = {"con", "ryan"};
		String[] report1 = {"ryan con", "ryan con", "ryan con", "ryan con"};
		int k1 = 3;
		System.out.println(Arrays.toString(solution(id_list1, report1, k1)));
	}

	public static int[] solution(String[] id_list, String[] report, int k) {
		List<String> reportList = Arrays.stream(report)
										.distinct()
										.collect(Collectors.toList());

		HashMap<String, Integer> cnt = new HashMap<>();

		for (String str : reportList) {
			String tmp = str.split(" ")[1];
			cnt.put(tmp, cnt.getOrDefault(tmp, 0) + 1);
		}

		List<String> idList = new LinkedList<>(Arrays.asList(id_list));
		int[] answer = new int[id_list.length];

		for (String str : reportList) {
			String[] tmp = str.split(" ");
			if (cnt.get(tmp[1]) >= k) {
				int idx = idList.indexOf(tmp[0]);
				answer[idx] += 1;
			}
		}

		return answer;
	}

}
