package programmers.level1;

public class P134240_푸드파이터대회 {

	public static void main(String[] args) {
		int[] food1 = {1, 3, 4, 6};
		int[] food2 = {1, 7, 1, 2};

		System.out.println(solution(food1));
		System.out.println(solution(food2));
	}

	public static String solution(int[] food) {
		String answer = "";
		int cur = 1;

		for (int i = 1; i < food.length; i++) {
			for (int j = 0; j < food[i] / 2; j++) {
				answer += cur + "";
			}
			cur++;

		}

		StringBuffer sb = new StringBuffer(answer);
		String reverse = sb.reverse()
						   .toString();

		answer += "0";

		return answer + reverse;
	}

}
