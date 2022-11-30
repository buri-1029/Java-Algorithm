package programmers.level1;

public class P132267_콜라문제 {

	public static void main(String[] args) {
		int a1 = 2;
		int b1 = 1;
		int n1 = 20;

		int a2 = 3;
		int b2 = 1;
		int n2 = 20;

		System.out.println(solution(a1, b1, n1));
		System.out.println(solution(a2, b2, n2));

	}

	public static int solution(int a, int b, int n) {
		int answer = 0;

		while (n >= a) {
			answer += n / a * b;
			n = (n / a * b) + (n % a);
		}

		return answer;
	}
}
