package programmers.courses;

import java.util.Arrays;

public class P96114_순열검사 {

	public static void main(String[] args) {
		int[] arr = {4, 1, 3, 2};
		System.out.println(solution(arr));

		int[] arr1 = {4, 1, 3};
		System.out.println(solution(arr1));

	}

	public static boolean solution(int[] arr) {
		int n = arr.length;
		int[] check = new int[n];

		for (int i = 0; i < n; i++) {
			check[i] = i + 1;
		}

		Arrays.sort(arr); // O(nlogn)

		return Arrays.equals(arr, check); // O(n)

		//		boolean answer = true;
		//		for (int i = 0; i < n; i++) {
		//			if (arr[i] != check[i]) {
		//				answer = false;
		//				break;
		//			}
		//		}

	}

}
