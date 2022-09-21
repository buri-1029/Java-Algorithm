package programmers.level2;

public class P12985_예상대진표 {

	public static void main(String[] args) {
		System.out.println(solution(8, 4, 7));
	}

	public static int solution(int n, int a, int b) {
		int answer = 0;
		int people = n;
		int range = 0;
		int group = 1;

		while (true) {
			answer++;

			group = people / 2;
			range = n / group;

			if ((a - 1) / range == (b - 1) / range) {
				break;
			}

			people /= 2;
		}

		return answer;
	}
}
