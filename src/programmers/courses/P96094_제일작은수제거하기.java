package programmers.courses;

import java.util.Arrays;

public class P96094_제일작은수제거하기 {

	public static void main(String[] args) {
		int[] arr1 = {4, 3, 2, 1};
		System.out.println(Arrays.toString(solution(arr1)));

		int[] arr2 = {10};
		System.out.println(Arrays.toString(solution(arr2)));
	}

	public static int[] solution(int[] arr) {
		if (arr.length == 1) {
			return new int[]{-1};
		}

		return Arrays.stream(arr)
					 .filter(value -> value > Arrays.stream(arr)
													.min()
													.getAsInt())
					 .toArray();
	}
}
