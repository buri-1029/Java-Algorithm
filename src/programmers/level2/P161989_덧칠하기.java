package programmers.level2;

public class P161989_덧칠하기 {

	public static void main(String[] args) {
		int n = 5;
		int m = 4;
		int[] section = {1, 3,};
		System.out.println(solution(n, m, section));

	}

	public static int solution(int n, int m, int[] section) {
		int answer = 1;
		int tmp = section[0];

		for (int i = 1; i < section.length; i++) {
			if (tmp + m <= section[i]) {
				tmp = section[i];
				answer++;
			}
		}

		return answer;
	}
}
