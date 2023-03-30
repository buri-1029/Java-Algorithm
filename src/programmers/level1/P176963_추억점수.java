package programmers.level1;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class P176963_추억점수 {

	public static void main(String[] args) {
		String[] name = {"may", "kein", "kain", "radi"};
		int[] yearning = {5, 10, 1, 3};
		String[][] photo = {{"may", "kein", "kain", "radi"}, {"may", "kein", "brin", "deny"},
			{"kon", "kain", "may", "coni"}};

		System.out.println(Arrays.toString(solution(name, yearning, photo)));
	}

	public static int[] solution(String[] name, int[] yearning, String[][] photo) {
		Map<String, Integer> score = new HashMap<>();

		for (int i = 0; i < name.length; i++) {
			score.put(name[i], yearning[i]);
		}

		int[] answer = new int[photo.length];

		for (int i = 0; i < photo.length; i++) {
			int tmp = 0;
			for (int j = 0; j < photo[i].length; j++) {
				tmp += score.getOrDefault(photo[i][j], 0);
			}
			answer[i] = tmp;
		}

		return answer;
	}
}
