package programmers.level2;

import java.util.Arrays;

public class P49993_스킬트리 {

	public static void main(String[] args) {
		String skill = "CBD";
		String[] skill_trees = {"BACDE", "CBADF", "AECB", "BDA"};

		System.out.println(solution(skill, skill_trees));
	}

	public static int solution(String skill, String[] skill_trees) {
		int answer = 0;

		String[] arr = skill.split("");

		for (int i = 0; i < skill_trees.length; i++) {
			String tmp = skill_trees[i].replaceAll(Arrays.toString(arr), "");
			skill_trees[i] = tmp.isEmpty() ? skill_trees[i] :
				skill_trees[i].replaceAll(Arrays.toString(tmp.split("")), "");

		}

		for (int i = 0; i < skill_trees.length; i++) {
			if (skill.startsWith(skill_trees[i])) {
				answer++;
			}
		}

		return answer;
	}
}
