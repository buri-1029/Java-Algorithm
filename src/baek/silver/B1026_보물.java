package baek.silver;

import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

// 순열 이용 시 시간초과.. (B는 재배열하지 말라고 했는데...)
public class B1026_보물 {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int N = scan.nextInt();
		Integer[] A = new Integer[N];
		Integer[] B = new Integer[N];

		for (int i = 0; i < N; i++) {
			A[i] = scan.nextInt();
		}

		for (int i = 0; i < N; i++) {
			B[i] = scan.nextInt();
		}

		Arrays.sort(A);
		Arrays.sort(B, Collections.reverseOrder());

		int answer = 0;
		for (int i = 0; i < N; i++) {
			answer += (A[i] * B[i]);
		}

		System.out.println(answer);

	}

}
