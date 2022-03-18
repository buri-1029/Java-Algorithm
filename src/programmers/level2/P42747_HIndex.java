package programmers.level2;

import java.util.Arrays;

public class P42747_HIndex {

	public static void main(String[] args) {
		int[] citations = {3, 0, 6, 1, 5};

		System.out.println(solution(citations));
	}

	private static int solution(int[] citations) {
		int answer = 0;

		Arrays.sort(citations);

		// n편 중 h번 이상 인용된 논문이 h편 이상일 때 최대값이 h-index
		for (int i = 0; i < citations.length; i++) {
			int h = citations.length - i;

			if (citations[i] >= h) {
				answer = h;
				break;
			}
		}

		return answer;
	}

}
