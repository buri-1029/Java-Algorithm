package programmers.level1;

import java.util.Arrays;

public class P135808_과일장수 {

	public static void main(String[] args) {
		int k1 = 3;
		int m1 = 4;
		int[] score1 = {1, 2, 3, 1, 2, 3, 1};

		int k2 = 4;
		int m2 = 3;
		int[] score2 = {4, 1, 2, 2, 4, 4, 4, 4, 1, 2, 4, 2};

		System.out.println(solution(k1, m1, score1));
		System.out.println(solution(k2, m2, score2));
	}

	public static int solution(int k, int m, int[] score) {
		int answer = 0;

		Arrays.sort(score);

		for (int i = score.length - m; i >= 0; i -= m) {
			answer += score[i] * m;
		}

		return answer;
	}
}
