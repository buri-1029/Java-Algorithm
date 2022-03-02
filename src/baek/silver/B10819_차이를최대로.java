package baek.silver;

import java.util.Scanner;

public class B10819_차이를최대로 {

	static int ans = Integer.MIN_VALUE;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int[] A = new int[N];
		int[] S = new int[N];
		boolean[] V = new boolean[N];
		for (int i = 0; i < N; i++) {
			A[i] = sc.nextInt();
		}

		permutation(A, S, V, 0);
		System.out.println(ans);

		/* next_permutation 사용 */
		//		Arrays.sort(A);
		//		int ans = 0;
		//		do {
		//			int temp = calculate(A);
		//			ans = Math.max(ans, temp);
		//		} while (next_permutation(A));
		//		System.out.println(ans);

	}

	private static void permutation(int[] a, int[] s, boolean[] v, int idx) {
		if (idx == s.length) {
			int sum = 0;
			for (int i = 1; i < s.length; i++) {
				sum += Math.abs(s[i] - s[i - 1]);
			}
			ans = Math.max(ans, sum);
		}
		for (int i = 0; i < a.length; i++) {
			if (!v[i]) {
				v[i] = true;
				s[idx] = a[i];
				permutation(a, s, v, idx + 1);
				v[i] = false;
			}
		}
	}

	public static boolean next_permutation(int[] a) {
		int i = a.length - 1;
		while (i > 0 && a[i - 1] >= a[i]) {
			i -= 1;
		}
		if (i <= 0) {
			return false;
		}

		int j = a.length - 1;
		while (a[j] <= a[i - 1]) {
			j -= 1;
		}

		int temp = a[i - 1];
		a[i - 1] = a[j];
		a[j] = temp;

		j = a.length - 1;
		while (i < j) {
			temp = a[i];
			a[i] = a[j];
			a[j] = temp;
			i += 1;
			j -= 1;
		}
		return true;
	}

	public static int calculate(int a[]) {
		int sum = 0;
		for (int i = 1; i < a.length; i++) {
			sum += Math.abs(a[i] - a[i - 1]);
		}
		return sum;
	}
}
