package baek;

import java.util.Scanner;
/*
 * 다시 해보기
 * 1. i번째 오는 배열은 0 ~ i-1 까지의 배열을 한번씩 다시 돌아서 체크해야한다.
 * 2. a[i-1] < a[i] 이런 경우가 올 수 있다. 
 */

public class B11053_가장긴증가하는부분수열 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int max = 0;
		int[] D = new int[N + 1];
		int[] A = new int[N + 1];

		for (int i = 0; i < N; i++) {
			A[i] = sc.nextInt();
			D[i] = 1;
		}

		for (int i = 0; i < N; i++) {
			for (int j = 0; j <= i; j++) {
				if (A[j] < A[i] && D[j] >= D[i]) {
					D[i] = D[j] + 1;
				}
			}
		}

		for (int i = 0; i < N; i++) {
			if (D[i] > max)
				max = D[i];
		}
		System.out.println(max);
	}
}
