package programmers.level2;

public class P12900_2xn타일링 {

	public static void main(String[] args) {
		int n = 4;
		System.out.println(solution(n));

	}

	public static int solution(int n) {
		int answer = 1;

		int a = 1;
		int b = 1;

		for (int i = 1; i < n; i++) {
			answer = (a + b) % 1000000007;

			a = b;
			b = answer;
		}

		return answer;
	}

}
