package programmers.level3;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

public class P42579_베스트앨범 {

	public static void main(String[] args) {
		String[] genres = {"classic", "pop", "classic", "classic", "pop"};
		int[] plays = {500, 600, 150, 800, 2500};
		System.out.println(Arrays.toString(solution(genres, plays)));
	}

	public static int[] solution(String[] genres, int[] plays) {
		HashMap<String, Integer> map = new HashMap<>();

		for (int i = 0; i < genres.length; i++) {
			if (map.containsKey(genres[i])) {
				map.put(genres[i], map.get(genres[i]) + plays[i]);
				continue;
			}
			map.put(genres[i], plays[i]);
		}

		ArrayList<Integer> answer = new ArrayList<>();
		ArrayList<String> arr = new ArrayList<>(map.keySet());
		arr.sort((o1, o2) -> (map.get(o2)
								 .compareTo(map.get(o1))));

		for (String s : arr) {
			HashMap<Integer, Integer> tmp = new HashMap<>();
			for (int i = 0; i < genres.length; i++) {
				if (s.equals(genres[i])) {
					tmp.put(i, plays[i]);
				}
			}

			ArrayList<Integer> keyList = new ArrayList<>(tmp.keySet());
			keyList.sort((o1, o2) -> (tmp.get(o2)
										 .compareTo(tmp.get(o1))));
			int cnt = 0;
			for (Integer k : keyList) {
				if (cnt > 1) {
					break;
				}
				answer.add(k);
				cnt++;
			}
		}

		return answer.stream()
					 .mapToInt(Integer::intValue)
					 .toArray();
	}
}
