package programmers.level2;

public class P135807_숫자카드나누기 {

	public static void main(String[] args) {
		int[] arrayA = {10, 20};
		int[] arrayB = {5, 17};
		System.out.println(solution(arrayA, arrayB));
	}

	public static int solution(int[] arrayA, int[] arrayB) {
		int answer = 0;

		int gcdA = arrayA[0];
		int gcdB = arrayB[0];

		for (int i = 1; i < arrayA.length; i++) {
			gcdA = gcd(gcdA, arrayA[i]);
			gcdB = gcd(gcdB, arrayB[i]);
		}

		if (notDivisible(arrayB, gcdA)) {
			if (answer < gcdA) {
				answer = gcdA;
			}
		}

		if (notDivisible(arrayA, gcdB)) {
			if (answer < gcdB) {
				answer = gcdB;
			}
		}

		return answer;
	}

	public static boolean notDivisible(int[] arr, int num) {
		for (int n : arr) {
			if (n % num == 0) {
				return false;
			}
		}

		return true;
	}

	public static int gcd(int a, int b) {
		if (a % b == 0) {
			return b;
		}

		return gcd(b, a % b);
	}

}
