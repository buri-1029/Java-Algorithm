package programmers.level2;

import java.util.Arrays;

public class P68645_삼각달팽이 {

	public static void main(String[] args) {
		System.out.println(Arrays.toString(solution(4)));
		System.out.println(Arrays.toString(solution(5)));
	}

	public static int[] solution(int n) {
		int[] answer = new int[n * (n + 1) / 2];
		int[][] arr = new int[n][n];

		int x = -1;
		int y = 0;
		int idx = 1;

		for (int i = 0; i < n; i++) {
			for (int j = i; j < n; j++) {
				if (i % 3 == 0) {
					x++;
				} else if (i % 3 == 1) {
					y++;
				} else {
					x--;
					y--;
				}

				arr[x][y] = idx++;
			}
		}

		idx = 0;
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				if (arr[i][j] == 0) {
					break;
				}

				answer[idx++] = arr[i][j];
			}
		}

		return answer;
	}
}
