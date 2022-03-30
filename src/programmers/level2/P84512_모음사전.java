package programmers.level2;

import java.util.List;

public class P84512_모음사전 {

	public static void main(String[] args) {
		String word1 = "AAAAE";
		String word2 = "AAAE";
		String word3 = "I";
		String word4 = "EIO";

		System.out.println(solution(word1));
		System.out.println(solution(word2));
		System.out.println(solution(word3));
		System.out.println(solution(word4));

	}

	public static int solution(String word) {
		int answer = 0;

		int[] arr = {781, 156, 31, 6, 1};
		Character[] charArr = {'A', 'E', 'I', 'O', 'U'};

		for (int i = 0; i < word.length(); i++) {
			answer += arr[i] * List.of(charArr)
								   .indexOf(word.charAt(i)) + 1;
		}

		return answer;
	}
}
