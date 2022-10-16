package programmers.level2;

import java.util.Arrays;

public class P77885_2개이하로다른비트 {

	public static void main(String[] args) {
		long[] numbers = {2, 7};
		System.out.println(Arrays.toString(solution(numbers)));

	}

	public static long[] solution(long[] numbers) {
		long[] answer = new long[numbers.length];

		for (int i = 0; i < numbers.length; i++) {
			String str = Long.toBinaryString(numbers[i]);

			if (numbers[i] % 2 == 0) {
				answer[i] = numbers[i] + 1;
			} else {
				int last = str.lastIndexOf("0");
				int first = str.indexOf("1", last);

				if (last == -1) {
					numbers[i] += 1;
					str = Long.toBinaryString(numbers[i]);
					str = str.substring(0, 2) +
						str.substring(2)
						   .replace("0", "1");

				} else {
					str = str.substring(0, last) + "1" +
						str.substring(last + 1, first) + "0" +
						str.substring(first + 1);
				}

				answer[i] = Long.parseLong(str, 2);
			}


		}
		return answer;
	}

}
