package codility;

import java.util.HashMap;
import java.util.Map;

public class OddOccurrencesInArray {

	public static void main(String[] args) {
		int[] A = {9, 3, 9, 3, 9, 7, 9};

		System.out.println(solution(A));
	}

	public static int solution(int[] A) {
		Map<Integer, Integer> map = new HashMap<>();

		for (int i : A) {
			map.put(i, map.containsKey(i) ? map.get(i) + 1 : 1);
		}

		return map.keySet()
				  .stream()
				  .filter(key -> map.get(key) % 2 != 0)
				  .mapToInt(Integer::intValue)
				  .sum();


		/*	다른 사람 코드..
			int answer = 0;

			for (int num : A) {
				answer ^= num;
			}

			return answer;
		 */
	}
}
