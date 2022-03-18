package programmers.level2;

public class P12953_N개의최소공배수 {

	public static void main(String[] args) {
		int[] arr1 = {2, 6, 8, 14};
		int[] arr2 = {1, 2, 3};

		int ans1 = solution(arr1);
		int ans2 = solution(arr2);

		System.out.println(ans1);
		System.out.println(ans2);
	}

	private static int solution(int[] arr) {
		int answer = arr[0];
		for (int i = 1; i < arr.length; i++) {
			answer = lcm(answer, arr[i]);
		}
		return answer;
	}

	private static int lcm(int a, int b) {
		return a * b / gcd(a, b);
	}

	private static int gcd(int a, int b) {
		while (b > 0) {
			int tmp = b;
			b = a % b;
			a = tmp;
		}
		return a;
	}
}

