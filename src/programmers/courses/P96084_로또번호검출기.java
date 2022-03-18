package programmers.courses;

import java.util.HashSet;
import java.util.Set;

public class P96084_로또번호검출기 {

	public static void main(String[] args) {
		int[] arr = {4, 7, 32, 43, 22, 19};
		System.out.println(solution(arr));

		int[] arr1 = {3, 19, 34, 39, 39, 20};
		System.out.println(solution(arr1));
	}

	public static boolean solution(int[] lotto) {
		Set<Integer> set = new HashSet<>();
		for (int num : lotto) {
			if (num < 1 || num > 45) {
				return false;
			}
			set.add(num);
		}

		return set.size() == lotto.length;
	}

}
