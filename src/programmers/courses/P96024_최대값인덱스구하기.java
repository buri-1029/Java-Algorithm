package programmers.courses;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class P96024_최대값인덱스구하기 {

	public static void main(String[] args) {
		int[] arr = {1, 3, 5, 4, 5, 2, 1};
		System.out.println(Arrays.toString(solution(arr)));

		int[] arr1 = {3, 6, 10, 1, 7, 2, 4, 6, 10, 9};
		System.out.println(Arrays.toString(solution(arr1)));
	}

	public static int[] solution(int[] arr) {
		// 배열 사용
		int max = 0;
		for (int num : arr) {
			max = Math.max(num, max);
		}

		int cnt = 0;
		for (int num : arr) {
			cnt = num == max ? cnt + 1 : cnt;
		}

		int[] answer = new int[cnt];
		int idx = 0;

		for (int i = 0; i < arr.length; i++) {
			if (arr[i] == max) {
				answer[idx++] = i;
			}
		}

		// 리스트 사용
		List<Integer> list = new LinkedList<>();
		for (int i = 0; i < arr.length; i++) {
			if (arr[i] == max) {
				list.add(i);
			}
		}

		return list.stream()
				   .mapToInt(Integer::intValue)
				   .toArray();

		/*
		  Stream 사용
		  int max = Arrays.stream(arr)
		  				   .max()
		  				   .getAsInt();

		  return IntStream.range(0, arr.length)
		  				   .filter(i -> arr[i] == max)
		  				   .toArray();

		 */

	}
}
