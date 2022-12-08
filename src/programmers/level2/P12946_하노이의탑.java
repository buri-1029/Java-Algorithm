package programmers.level2;

import java.util.Arrays;

public class P12946_하노이의탑 {

	static private int index = 0;

	public static void main(String[] args) {
		int n = 2;
		System.out.println(Arrays.toString(solution(n)));
	}

	public static int[][] solution(int n) {
		int[][] answer = new int[(int) (Math.pow(2, n) - 1)][2];

		hanoi(n, 1, 3, 2, answer);

		return answer;
	}

	private static void hanoi(int n, int a, int b, int c, int[][] answer) {
		if (n == 1) {
			answer[index++] = new int[]{a, b};
		} else {
			hanoi(n - 1, a, c, b, answer);
			answer[index++] = new int[]{a, b};
			hanoi(n - 1, c, b, a, answer);
		}
	}
}
