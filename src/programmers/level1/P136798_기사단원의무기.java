package programmers.level1;

public class P136798_기사단원의무기 {

	public static void main(String[] args) {
		int number = 5;
		int limit = 3;
		int power = 2;

		System.out.println(solution(number, limit, power));
	}

	public static int solution(int number, int limit, int power) {
		int answer = 0;

		for (int i = 1; i <= number; i++) {
			int cnt = 0;
			for (int j = 1; j * j <= i; j++) {
				if (j * j == i) {
					cnt++;
				} else if (i % j == 0) {
					cnt += 2;
				}
			}

			answer += cnt > limit ? power : cnt;
		}

		return answer;
	}
}
