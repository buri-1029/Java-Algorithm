package programmers.Level2;

import java.util.Arrays;

public class P42584_주식가격 {

	public static void main(String[] args) {
		int[] prices = {1, 2, 3, 2, 3};

		System.out.println(Arrays.toString(solution(prices)));
	}

	private static int[] solution(int[] prices) {
		int[] answer = new int[prices.length];

		for (int i = 0; i < prices.length; i++) {
			for (int j = i + 1; j < prices.length; j++) {
				answer[i]++;

				if (prices[i] > prices[j]) {
					break;
				}
			}
		}

		return answer;
	}

}
