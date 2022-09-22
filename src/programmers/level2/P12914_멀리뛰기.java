package programmers.level2;

public class P12914_멀리뛰기 {

	public static void main(String[] args) {
		int n1 = 4;
		int n2 = 3;

		System.out.println(solution(n1));
		System.out.println(solution(n2));
	}

	public static long solution(int n) {
		long[] arr = new long[2001];

		arr[1] = 1;
		arr[2] = 2;

		for (int i = 3; i < 2001; i++) {
			arr[i] = (arr[i - 1] + arr[i - 2]) % 1234567;
		}

		return arr[n];
	}
}
