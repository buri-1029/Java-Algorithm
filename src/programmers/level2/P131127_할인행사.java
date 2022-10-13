package programmers.level2;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class P131127_할인행사 {

	public static void main(String[] args) {
		String[] want = {"banana", "apple", "rice", "pork", "pot"};
		int[] number = {3, 2, 2, 2, 1};
		String[] discount = {"chicken", "apple", "apple", "banana", "rice", "apple", "pork",
			"banana", "pork", "rice", "pot", "banana", "apple", "banana"};

		System.out.println(solution(want, number, discount));

	}

	public static int solution(String[] want, int[] number, String[] discount) {
		int answer = 0;

		for (int i = 0; i < discount.length - 9; i++) {

			List<String> list = Arrays.stream(discount, i, i + 10)
									  .collect(Collectors.toList());

			int cnt = 0;

			for (int j = 0; j < want.length; j++) {
				if (Collections.frequency(list, want[j]) == number[j]) {
					cnt++;
				}
			}

			if (cnt == want.length) {
				answer++;
			}

		}

		return answer;
	}
}
