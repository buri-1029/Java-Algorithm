package programmers.level2;

public class P140107_점찍기 {

	public static void main(String[] args) {
		int k = 2;
		int d = 4;
		System.out.println(solution(k, d));
	}

	public static long solution(int k, int d) {
		long answer = 0;

		for (int i = 0; i <= d; i += k) {
			long dd = (long) d * d;
			long ii = (long) i * i;
			int top = (int) Math.sqrt(dd - ii);
			answer += (top / k) + 1;
		}

		return answer;
	}
}
