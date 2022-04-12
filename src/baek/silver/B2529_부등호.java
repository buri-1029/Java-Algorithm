package baek.silver;

import java.util.Scanner;

public class B2529_부등호 {

	static char[] arr;
	static int[] num;
	static int[] select;
	static boolean[] visited;
	static long max = Long.MIN_VALUE;
	static long min = Long.MAX_VALUE;

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int k = scan.nextInt();
		int K = k + 1;
		int N = 10;

		arr = new char[K];
		num = new int[N];

		for (int i = 1; i < K; i++) {
			arr[i] = scan.next()
						 .charAt(0);
		}

		select = new int[K];
		visited = new boolean[N];

		for (int i = 0; i < N; i++) {
			num[i] = i;
		}

		permutation(0);

		System.out.println(max + "");
		System.out.println((min / (int) Math.pow(10, k)) > 0 ? min : "0" + min);

	}

	private static void permutation(int idx) {
		if (idx == select.length) {
			int before = select[0];
			long tmp = (long) (before * Math.pow(10, select.length - 1));
			boolean flag = true;

			for (int i = 1; i < select.length; i++) {
				if (arr[i] == '<' && before < select[i]) {
					tmp += select[i] * Math.pow(10, select.length - 1 - i);
				} else if (arr[i] == '>' && before > select[i]) {
					tmp += select[i] * Math.pow(10, select.length - 1 - i);
				} else {
					flag = false;
					break;
				}

				before = select[i];
			}

			if (flag) {
				max = Math.max(max, tmp);
				min = Math.min(min, tmp);
			}

			return;
		}

		for (int i = 0; i < num.length; i++) {
			if (!visited[i]) {
				visited[i] = true;
				select[idx] = num[i];
				permutation(idx + 1);
				visited[i] = false;
			}
		}

	}

}
