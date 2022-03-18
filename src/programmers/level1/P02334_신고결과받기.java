package programmers.level1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

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
		ArrayList<String> idList = new ArrayList<>(Arrays.asList(id_list));
		HashMap<String, Integer> reportCnt = new HashMap<>();

		ArrayList<String> reportList = new ArrayList<>(report.length);
		for (String str : report) {
			if (!reportList.contains(str)) {
				reportList.add(str);
			}
		}

		for (String str : reportList) {
			String[] tmp = str.split(" ");
			int count = reportCnt.getOrDefault(tmp[1], 0);
			reportCnt.put(tmp[1], count + 1);
		}

		int[] answer = new int[id_list.length];

		for (String str : reportList) {
			String[] tmp = str.split(" ");
			if (reportCnt.get(tmp[1]) >= k) {
				int idx = idList.indexOf(tmp[0]);
				answer[idx] += 1;
			}
		}

		return answer;
	}

}
