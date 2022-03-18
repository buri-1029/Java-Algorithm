package programmers.courses;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class P96086_같은숫자는싫어 {

	public static void main(String[] args) {
		int[] arr = {1, 1, 3, 3, 0, 1, 1};
		System.out.println(Arrays.toString(solution(arr)));

		int[] arr1 = {4, 4, 4, 3, 3};
		System.out.println(Arrays.toString(solution(arr1)));
	}

	public static int[] solution(int[] arr) {
		int before = arr[0];
		List<Integer> list = new LinkedList<>();
		list.add(before);

		for (int i = 1; i < arr.length; i++) {
			if (before != arr[i]) {
				list.add(arr[i]);
				before = arr[i];
			}
		}

		return list.stream()
				   .mapToInt(Integer::intValue)
				   .toArray();
	}
}
