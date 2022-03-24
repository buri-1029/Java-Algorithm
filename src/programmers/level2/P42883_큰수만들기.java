package programmers.level2;

import java.util.Arrays;

public class P42883_큰수만들기 {

	static int answer = 0;
	static int[] arr, select;

	public static void main(String[] args) {
		String number = "1924";
		int k = 2;
		System.out.println(solution(number, k));

		String number1 = "1231234";
		int k1 = 3;
		System.out.println(solution(number1, k1));
	}

	public static String solution(String number, int k) {
		arr = Arrays.stream(number.split(""))
					.mapToInt(Integer::parseInt)
					.toArray();
		select = new int[number.length() - k];
		combination(0, 0);
		return String.valueOf(answer);
	}

	private static void combination(int idx, int k) {
		if (k == select.length) {
			int sum = 0, tmp = 1;
			for (int i = select.length - 1; i >= 0; i--) {
				sum += (select[i] * tmp);
				tmp *= 10;
			}
			answer = Math.max(answer, sum);
			return;
		}

		for (int i = idx; i < arr.length; i++) {
			select[k] = arr[i];
			combination(i + 1, k + 1);
		}

	}
}
