package programmers.level1;

import java.util.Arrays;
import java.util.HashMap;

public class P142086_가장가까운같은글자 {

	public static void main(String[] args) {
		String s1 = "banana";
		System.out.println(Arrays.toString(solution(s1)));

		String s2 = "foobar";
		System.out.println(Arrays.toString(solution(s2)));
	}

	public static int[] solution(String s) {
		int[] answer = new int[s.length()];

		HashMap<Character, Integer> letter = new HashMap<>();

		for (int i = 0; i < s.length(); i++) {

			if (!letter.containsKey(s.charAt(i))) {
				letter.put(s.charAt(i), i);
				answer[i] = -1;
			} else {
				answer[i] = i - letter.get(s.charAt(i));
				letter.put(s.charAt(i), i);
			}
		}

		return answer;
	}
}
