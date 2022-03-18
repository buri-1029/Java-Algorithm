package programmers.level2;

public class P12945_피보나치수 {

	public static void main(String[] args) {
		int n = 1234568;
		System.out.println(solution(n));
	}

	private static int solution(int n) {
		int[] fibo = new int[n + 1];

		fibo[0] = 0;
		fibo[1] = 1;

		for (int i = 2; i <= n; i++) {
			fibo[i] = (fibo[i - 2] % 1234567) + (fibo[i - 1] % 1234567);
		}

		return fibo[n] % 1234567;
	}

}
