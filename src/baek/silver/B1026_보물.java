package baek.silver;

import java.util.Scanner;

// 순열 이용 시 시간초과.. (B는 재배열하지 말라고 했는데...)
public class B1026_보물 {

	static int[] A, B;
	static int[] select;
	static boolean[] visited;
	static int min = Integer.MAX_VALUE;

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int N = scan.nextInt();
		A = new int[N];
		B = new int[N];

		for (int i = 0; i < N; i++) {
			A[i] = scan.nextInt();
		}

		for (int i = 0; i < N; i++) {
			B[i] = scan.nextInt();
		}

		select = new int[N];
		visited = new boolean[N];

		permutation(0);

		System.out.println(min);

	}

	private static void permutation(int idx) {
		if (idx == select.length) {
			int sum = 0;
			for (int i = 0; i < select.length; i++) {
				sum += (select[i] * B[i]);
			}

			min = Math.min(min, sum);

			return;
		}

		for (int i = 0; i < A.length; i++) {
			if (!visited[i]) {
				visited[i] = true;
				select[idx] = A[i];
				permutation(idx + 1);
				visited[i] = false;
			}
		}
	}
}
