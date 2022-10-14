package programmers.level2;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class P131701_연속부분수열합의개수 {

	public static void main(String[] args) {
		int[] elements = {7, 9, 1, 1, 4};
		System.out.println(solution(elements));
	}

	public static int solution(int[] elements) {
		Set<Integer> count = new HashSet<>();
		int len = elements.length;

		for (int i = 1; i <= len; i++) {
			for (int j = 0; j < len; j++) {
				int num;

				if (j + i >= len) {
					num = Arrays.stream(elements, j, len)
								.sum() +
						Arrays.stream(elements, 0, (j + i) % len)
							  .sum();
				} else {
					num = Arrays.stream(elements, j, j + i)
								.sum();
				}
				count.add(num);
			}
		}

		return count.size();
	}

}
