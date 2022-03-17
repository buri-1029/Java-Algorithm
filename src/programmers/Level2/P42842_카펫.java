package programmers.Level2;

import java.util.Arrays;

public class P42842_카펫 {

	public static void main(String[] args) {
		int brown = 10;
		int yellow = 2;

		System.out.println(Arrays.toString(solution(brown, yellow)));
	}

	public static int[] solution(int brown, int yellow) {
		int[] answer = new int[2];

		int area = brown + yellow;

		for (int i = 1; i <= area; i++) {
			int row = i;
			int col = area / row;

			if (row > col) {
				continue;
			}

			if ((row - 2) * (col - 2) == yellow) {
				answer[0] = col;
				answer[1] = row;

				return answer;
			}

		}

		return answer;
	}
}
