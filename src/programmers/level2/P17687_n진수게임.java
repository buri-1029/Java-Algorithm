package programmers.level2;

public class P17687_n진수게임 {

	public static void main(String[] args) {
		int n1 = 2;
		int t1 = 4;
		int m1 = 2;
		int p1 = 1;

		System.out.println(solution(n1, t1, m1, p1));

		int n2 = 16;
		int t2 = 16;
		int m2 = 2;
		int p2 = 1;

		System.out.println(solution(n2, t2, m2, p2));

	}

	public static String solution(int n, int t, int m, int p) {
		StringBuilder sb = new StringBuilder();
		StringBuilder answer = new StringBuilder();

		int num = 0;

		while (sb.length() < m * t) {
			sb.append(Integer.toString(num++, n));
		}

		for (int i = p - 1; i < m * t; i = i + m) {
			answer.append(sb.charAt(i));
		}

		return answer.toString()
					 .toUpperCase();
	}
}
