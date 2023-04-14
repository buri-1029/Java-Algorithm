package programmers.level2;

import java.util.Arrays;
import java.util.Comparator;

public class P181188_요격시스템 {

	public static void main(String[] args) {
		int[][] targets = {{4, 5}, {4, 8}, {10, 14}, {11, 13}, {5, 12}, {3, 7}, {1, 4}};
		System.out.println(solution(targets));
	}

	public static int solution(int[][] targets) {
		int answer = 0;
		Arrays.sort(targets, Comparator.comparingInt(v -> v[1]));

		int end = targets[0][1];

		for (int[] target : targets) {
			int s = target[0];
			int e = target[1];

			if (end <= s) {
				end = e;
				answer++;
			}

		}

		return answer + 1;
	}
}
