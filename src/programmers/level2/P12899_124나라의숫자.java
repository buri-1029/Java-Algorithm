package programmers.level2;

public class P12899_124나라의숫자 {

	public static void main(String[] args) {
		System.out.println(solution(1));
		System.out.println(solution(4));
	}

	public static String solution(int n) {
		StringBuilder answer = new StringBuilder();

		while (n > 0) {
			int tmp = n % 3;
			n /= 3;

			if (tmp == 0) {
				tmp = 4;
				n -= 1;
			}

			answer.insert(0, tmp);
		}

		return answer.toString();
	}
}
