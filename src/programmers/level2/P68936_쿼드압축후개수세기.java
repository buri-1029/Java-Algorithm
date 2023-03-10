package programmers.level2;

import java.util.Arrays;

public class P68936_쿼드압축후개수세기 {

	static int[] answer;

	public static void main(String[] args) {
		int[][] arr = {{1, 1, 1, 1, 1, 1, 1, 1}, {0, 1, 1, 1, 1, 1, 1, 1}, {0, 0, 0, 0, 1, 1, 1, 1},
			{0, 1, 0, 0, 1, 1, 1, 1}, {0, 0, 0, 0, 0, 0, 1, 1}, {0, 0, 0, 0, 0, 0, 0, 1},
			{0, 0, 0, 0, 1, 0, 0, 1}, {0, 0, 0, 0, 1, 1, 1, 1}};

		System.out.println(Arrays.toString(solution(arr)));
	}

	public static int[] solution(int[][] arr) {
		answer = new int[2];

		quad(arr, 0, 0, arr.length);

		return answer;
	}

	private static void quad(int[][] arr, int r, int c, int len) {
		boolean isZero = true;
		boolean isOne = true;

		for (int i = r; i < r + len; i++) {
			for (int j = c; j < c + len; j++) {
				if (arr[i][j] == 1) {
					isZero = false;
				}
				if (arr[i][j] == 0) {
					isOne = false;
				}
			}
		}

		if (isOne) {
			answer[1]++;
			return;
		}

		if (isZero) {
			answer[0]++;
			return;
		}

		quad(arr, r, c, len / 2);
		quad(arr, r + len / 2, c, len / 2);
		quad(arr, r, c + len / 2, len / 2);
		quad(arr, r + len / 2, c + len / 2, len / 2);

	}
}
