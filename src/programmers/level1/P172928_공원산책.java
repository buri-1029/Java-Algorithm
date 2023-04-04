package programmers.level1;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class P172928_공원산책 {

	public static void main(String[] args) {
		String[] park = {"SOO", "OXX", "OOO"};
		String[] routes = {"E 2", "S 2", "W 1"};
		System.out.println(Arrays.toString(solution(park, routes)));
	}

	public static int[] solution(String[] park, String[] routes) {
		int[] answer = new int[2];

		Map<Character, int[]> nav = new HashMap<>();
		nav.put('S', new int[]{1, 0});
		nav.put('N', new int[]{-1, 0});
		nav.put('W', new int[]{0, -1});
		nav.put('E', new int[]{0, 1});

		for (int i = 0; i < park.length; i++) {
			for (int j = 0; j < park[0].length(); j++) {
				if (park[i].charAt(j) == 'S') {
					answer[0] = i;
					answer[1] = j;
				}
			}
		}

		for (String route : routes) {
			int distance = route.charAt(2) - '0';
			boolean flag = true;

			int nx = answer[0];
			int ny = answer[1];
			int[] dir = nav.get(route.charAt(0));

			for (int i = 1; i <= distance; i++) {
				nx += dir[0];
				ny += dir[1];

				if (nx >= park.length || nx < 0 || ny >= park[0].length() || ny < 0
					|| park[nx].charAt(ny) == 'X') {
					flag = false;
					break;
				}
			}

			if (flag) {
				answer[0] += dir[0] * distance;
				answer[1] += dir[1] * distance;
			}
		}

		return answer;
	}
}
