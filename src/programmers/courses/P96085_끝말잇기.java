package programmers.courses;

import java.util.HashSet;
import java.util.Set;

public class P96085_끝말잇기 {

	public static void main(String[] args) {
		String[] words = {"tank", "kick", "know", "wheel", "land", "dream"};
		System.out.println(solution(words));

		String[] words1 = {"tank", "kick", "know", "wheel", "land", "dream",
			"mother", "robot", "tank"};
		System.out.println(solution(words1));
	}

	public static boolean solution(String[] words) {
		Set<String> set = new HashSet<>();
		set.add(words[0]);
		String before = words[0];

		for (int i = 1; i < words.length; i++) {
			if (before.charAt(before.length() - 1) != words[i].charAt(0)) {
				return false;
			}
			if (!set.add(words[i])) {
				return false;
			}

			set.add(words[i]);
			before = words[i];
		}

		return true;
	}

}
