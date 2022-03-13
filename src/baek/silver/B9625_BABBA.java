package baek.silver;

import java.util.Scanner;

public class B9625_BABBA {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int K = scan.nextInt();

		int[] A = new int[K + 1];
		int[] B = new int[K + 1];

		A[0] = 1;
		A[1] = 0;

		B[0] = 0;
		B[1] = 1;

		for (int i = 2; i < K + 1; i++) {
			A[i] = B[i - 1];
			B[i] = B[i - 2] + B[i - 1];
		}

		//		int A = 0;
		//		int B = 1;
		//		int sum = 0;
		//
		//		for (int i = 1; i < K; i++) {
		//			sum = A + B;
		//			A = B;
		//			B = sum;
		//		}

		System.out.println(A[K] + " " + B[K]);
	}

}
