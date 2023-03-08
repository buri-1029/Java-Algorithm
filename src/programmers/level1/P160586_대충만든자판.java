package programmers.level1;

import java.util.Arrays;
import java.util.HashMap;

public class P160586_대충만든자판 {

	public static void main(String[] args) {
		//		String[] keymap = {"ABACD", "BCEFD"};
		//		String[] target = {"ABCD", "AABB"};

		String[] keymap = {"AGZ", "BSSS"};
		String[] target = {"ASA", "BGZ"};
		System.out.println(Arrays.toString(solution(keymap, target)));
	}

	public static int[] solution(String[] keymap, String[] targets) {
		int[] answer = new int[targets.length];
		HashMap<Character, Integer> map = new HashMap<>();

		for (String key : keymap) {
			for (int i = 0; i < key.length(); i++) {
				char ch = key.charAt(i);

				if (!map.containsKey(ch) || i < map.get(ch)) {
					map.put(ch, i + 1);
				}
			}
		}

		for (int i = 0; i < targets.length; i++) {
			int cnt = 0;

			for (int j = 0; j < targets[i].length(); j++) {
				char ch = targets[i].charAt(j);
				if (!map.containsKey(ch)) {
					cnt = 0;
					break;
				} else {
					cnt += map.get(ch);
				}
			}
			answer[i] = cnt == 0 ? -1 : cnt;
		}

		return answer;
	}
}
