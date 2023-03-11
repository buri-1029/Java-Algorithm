package programmers.level2;

import java.util.Arrays;

public class P12913_땅따먹기 {

	public static void main(String[] args) {
		int[][] land = {{1, 2, 3, 5}, {5, 6, 7, 8}, {4, 3, 2, 1}};
		System.out.println(solution2(land));
	}

	public static int solution1(int[][] land) {
		for (int i = 1; i < land.length; i++) {
			land[i][0] += Math.max(Math.max(land[i - 1][1], land[i - 1][2]), land[i - 1][3]);
			land[i][1] += Math.max(Math.max(land[i - 1][0], land[i - 1][2]), land[i - 1][3]);
			land[i][2] += Math.max(Math.max(land[i - 1][1], land[i - 1][0]), land[i - 1][3]);
			land[i][3] += Math.max(Math.max(land[i - 1][1], land[i - 1][2]), land[i - 1][0]);
		}

		int[] answer = land[land.length - 1];
		Arrays.sort(answer);

		return answer[answer.length - 1];
	}

	public static int solution2(int[][] land) {
		int answer;

		for (int i = 1; i < land.length; i++) {
			for (int j = 0; j < 4; j++) {
				int max = 0;

				for (int k = 0; k < 4; k++) {
					if (j == k) {
						continue;
					}

					max = Math.max(land[i - 1][k], max);
				}
				land[i][j] += max;
			}
		}

		answer = Math.max(
			land[land.length - 1][0],
			Math.max(
				land[land.length - 1][1],
				Math.max(land[land.length - 1][2], land[land.length - 1][3])
			)
		);

		return answer;
	}
}
