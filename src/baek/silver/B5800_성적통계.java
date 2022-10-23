package baek.silver;

import java.util.Arrays;
import java.util.Scanner;

public class B5800_성적통계 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int K = sc.nextInt();

		for (int k = 0; k < K; k++) {
			int N = sc.nextInt();
			int[] score = new int[N];

			for (int i = 0; i < N; i++) {
				score[i] = sc.nextInt();
			}

			Arrays.sort(score);

			int max = 0;

			for (int i = N - 1; i > 0; i--) {
				max = Math.max(max, score[i] - score[i - 1]);
			}

			System.out.println("Class " + (k + 1));
			System.out.println(
				"Max " + score[N - 1] + ", Min " + score[0] + ", Largest gap " + max);
		}
	}
}
