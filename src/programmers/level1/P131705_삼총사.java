package programmers.level1;

import java.util.Arrays;

public class P131705_삼총사 {

	public static int answer;
	public static int[] arr, select;

	public static void main(String[] args) {
		int[] number1 = {2, 3, 0, 2, -5};
		int[] number2 = {-3, -2, -1, 0, 1, 2, 3};
		int[] number3 = {-1, 1, -1, 1};

		System.out.println(solution(number1));
		System.out.println(solution(number2));
		System.out.println(solution(number3));

	}

	public static int solution(int[] number) {
		answer = 0;
		arr = Arrays.copyOf(number, number.length);
		select = new int[3];

		combination(0, 0);

		return answer;
	}

	private static void combination(int idx, int k) {
		if (k == select.length) {
			int sum = 0;
			for (int j : select) {
				sum += j;
			}

			if (sum == 0) {
				answer++;
			}

			return;
		}

		for (int i = idx; i < arr.length; i++) {
			select[k] = arr[i];
			combination(i + 1, k + 1);
		}
	}

}
