package programmers.level2;

import java.util.HashSet;
import java.util.Set;

public class P42839_소수찾기 {

	static String[] input, select;
	static boolean[] visit;
	static Set<Integer> primeSet;

	public static void main(String[] args) {
		String numbers1 = "17";
		String numbers2 = "011";

		System.out.println(solution(numbers1));
		System.out.println(solution(numbers2));
	}

	private static int solution(String numbers) {
		String[] arrStr = numbers.split("");
		input = arrStr;
		primeSet = new HashSet<>();

		for (int i = 1; i <= arrStr.length; i++) {
			select = new String[i];
			visit = new boolean[arrStr.length];
			permutation(0);
		}

		int answer = 0;
		for (int primeNum : primeSet) {
			if (prime(primeNum)) {
				answer++;
			}
		}

		return answer;
	}

	private static void permutation(int k) {
		if (k == select.length) {
			String tmp = "";
			for (String strNum : select) {
				tmp += strNum;
			}
			primeSet.add(Integer.valueOf(tmp));

			return;
		}

		for (int i = 0; i < input.length; i++) {
			if (!visit[i]) {
				visit[i] = true;
				select[k] = input[i];
				permutation(k + 1);
				visit[i] = false;
			}
		}

	}

	private static boolean prime(int n) {
		if (n < 2) {
			return false;
		}

		for (int i = 2; i * i <= n; i++) {
			if (n % i == 0) {
				return false;
			}
		}

		return true;
	}

}
