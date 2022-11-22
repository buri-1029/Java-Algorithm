package baek.silver;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class B2992_크면서작은수 {

	static int N, M;
	static int[] arr, select;
	static boolean[] visit;
	static ArrayList<Integer> answer;


	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		M = String.valueOf(N)
				  .length();

		arr = new int[M];
		select = new int[M];
		visit = new boolean[M];
		answer = new ArrayList<>();

		int num = N;
		int idx = 0;
		while (num > 0) {
			arr[idx++] = num % 10;
			num /= 10;
		}

		permutation(0);

		if (answer.size() > 0) {
			Collections.sort(answer);
			System.out.println(answer.get(0));
		} else {
			System.out.println(0);
		}

	}

	private static void permutation(int k) {
		if (k == select.length) {
			int tmp = 0;
			int ten = (int) Math.pow(10, select.length - 1);
			for (int i = 0; i < select.length; i++) {
				tmp += select[i] * ten;
				ten /= 10;
			}

			if (tmp > N) {
				answer.add(tmp);
			}
		}

		for (int i = 0; i < arr.length; i++) {
			if (!visit[i]) {
				visit[i] = true;
				select[k] = arr[i];
				permutation(k + 1);
				visit[i] = false;
			}
		}
	}
}
