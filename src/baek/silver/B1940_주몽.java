package baek.silver;

import java.util.Arrays;
import java.util.Scanner;

public class B1940_주몽 {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int N = scan.nextInt();
		int M = scan.nextInt();

		int[] A = new int[N];

		for (int i = 0; i < N; i++) {
			A[i] = scan.nextInt();
		}

		Arrays.sort(A);

		int answer = 0;
		int left = 0;
		int right = N - 1;

		while (left < right) {
			if (A[left] + A[right] == M) {
				answer++;
				left++;
				right--;
			} else if (A[left] + A[right] > M) {
				right--;
			} else {
				left++;
			}
		}

		System.out.println(answer);
	}
}
