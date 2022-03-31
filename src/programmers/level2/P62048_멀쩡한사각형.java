package programmers.level2;

public class P62048_멀쩡한사각형 {

	public static void main(String[] args) {
		int w = 8;
		int h = 12;
		System.out.println(solution(w, h));
	}

	public static long solution(int w, int h) {
		long gcd = gcd(w, h);
		return ((long) w * h) - (((w / gcd) + (h / gcd) - 1) * gcd);
	}

	private static int gcd(int n, int m) {
		while (m != 0) {
			int tmp = n % m;
			n = m;
			m = tmp;
		}

		return n;
	}
}
