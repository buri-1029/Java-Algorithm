package programmers.Level2;

import java.util.Arrays;
import java.util.Collections;

public class P12941_최솟값만들기 {

	public static void main(String[] args) {
		int[] A1 = {1, 4, 2};
		int[] B1 = {5, 4, 4};

		int[] A2 = {1, 2};
		int[] B2 = {3, 4};

		System.out.println(solution(A1, B1));
		System.out.println(solution(A2, B2));
	}

	private static int solution(int[] A, int[] B) {
		int answer = 0;

		Integer[] tmpB = new Integer[B.length];
		for (int i = 0; i < B.length; i++) {
			tmpB[i] = B[i];
		}

		Arrays.sort(A);
		Arrays.sort(tmpB, Collections.reverseOrder());

		for (int i = 0; i < A.length; i++) {
			answer += A[i] * tmpB[i];
		}

		return answer;
	}

}
