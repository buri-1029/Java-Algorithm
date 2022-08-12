package codility;

import java.util.Arrays;

public class CyclicRotation_Arrays {

	public static void main(String[] args) {
		int[] A = {3, 8, 9, 7, 3};
		int K = 3;

		System.out.println(Arrays.toString(solution(A, K)));
	}

	private static int[] solution(int[] A, int K) {

		if (K == 0 || A.length == 0) {
			return A;
		}

		int[] answer = new int[A.length];

		for (int i = 0; i < A.length; i++) {
			int tmp = (i + K) % A.length;

			answer[tmp] = A[i];
		}

		return answer;
	}
}
