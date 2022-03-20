package programmers.courses;

import java.util.Arrays;

public class P96093_스킬트리 {

	public static void main(String[] args) {
		String skill = "CBD";
		String[] skill_trees = {"BACDE", "CBADF", "AECB", "BDA"};
		System.out.println(solution(skill, skill_trees));
	}

	public static int solution(String skill, String[] skill_trees) {

		return (int) Arrays.stream(skill_trees)
						   .map(s -> s.replaceAll("[^" + skill + "]", ""))
						   .filter(skill::startsWith)
						   .count();
	}
}
