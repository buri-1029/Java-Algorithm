package programmers.level2;

import java.util.Arrays;

public class P77885_2개이하로다른비트 {

	public static void main(String[] args) {
		long[] numbers = {2, 45};
		System.out.println(Arrays.toString(solution(numbers)));

	}

	public static long[] solution(long[] numbers) {
		long[] answer = new long[numbers.length];

		for (int i = 0; i < numbers.length; i++) {
			if (numbers[i] % 2 == 0) {
				answer[i] = numbers[i] + 1;
			} else {
				String str = Long.toBinaryString(numbers[i]);
				int idx = str.lastIndexOf("0");

				if (idx == -1) {
					str = "10" + str.substring(1);
				} else {
					str = str.substring(0, idx) + "10" + str.substring(idx + 2);
				}

				answer[i] = Long.parseLong(str, 2);
			}
		}

		return answer;
	}

}
