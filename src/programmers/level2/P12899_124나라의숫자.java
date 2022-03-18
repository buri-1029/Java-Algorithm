package programmers.level2;

public class P12899_124나라의숫자 {

	public static void main(String[] args) {
		int n = 1;
		System.out.println(solution(n));
	}

	private static String solution(int n) {
		String answer = "";

		while (n > 0) {
			int tmp = n % 3;
			n /= 3;

			if (tmp == 0) {
				tmp = 4;
				n -= 1;
			}
			answer = tmp + answer;
		}

		return answer;
	}
}
