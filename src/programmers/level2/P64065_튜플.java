package programmers.level2;

import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class P64065_튜플 {

	public static void main(String[] args) {
		String s1 = "{{2},{2,1},{2,1,3},{2,1,3,4}}";
		String s2 = "{{1,2,3},{2,1},{1,2,4,3},{2}}";
		String s3 = "{{20,111},{111}}";

		System.out.println(Arrays.toString(solution(s1)));
		System.out.println(Arrays.toString(solution(s2)));
		System.out.println(Arrays.toString(solution(s3)));
	}

	public static int[] solution(String s) {

		s = s.substring(1, s.length() - 1);
		String[] arr_s = s.split("},");

		Map<Integer, Integer> repeat = new HashMap<>();

		for (int i = 0; i < arr_s.length; i++) {
			arr_s[i] = arr_s[i].replace("{", "");
			arr_s[i] = arr_s[i].replace("}", "");

			String[] arr_n = arr_s[i].split(",");

			for (int j = 0; j < arr_n.length; j++) {
				int tmp = Integer.parseInt(arr_n[j]);
				repeat.put(tmp, repeat.containsKey(tmp) ? repeat.get(tmp) + 1 : 1);
			}
		}

		List<Map.Entry<Integer, Integer>> entryList = new LinkedList<>(repeat.entrySet());
		entryList.sort(((o1, o2) -> repeat.get(o2.getKey()) - repeat.get(o1.getKey())));

		int[] answer = new int[repeat.size()];

		int idx = 0;

		for (Map.Entry<Integer, Integer> entry : entryList) {
			answer[idx++] = entry.getKey();
		}

		return answer;
	}
}
