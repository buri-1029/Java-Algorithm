package programmers.level2;

public class P92335_k진수소수 {

	public static void main(String[] args) {
		int n = 437674;
		int k = 3;

		System.out.println(solution(n, k));
	}

	public static int solution(int n, int k) {
		int answer = 0;

		String conversion = Integer.toString(n, k);
		String[] arr = conversion.split("0+");

		for (String s : arr) {
			if (!s.equals("") && prime(s)) {
				answer++;
			}
		}

		return answer;
	}

	private static boolean prime(String n) {
		long l = Long.parseLong(n);

		if (l < 2) {
			return false;
		}

		for (int i = 2; i <= (int) Math.sqrt(l); i++) {
			if (l % i == 0) {
				return false;
			}
		}

		return true;
	}
}
