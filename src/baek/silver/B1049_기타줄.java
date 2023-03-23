package baek.silver;

import java.util.Arrays;
import java.util.Scanner;

public class B1049_기타줄 {

	public static void main(String[] args) throws Exception {

		Scanner scan = new Scanner(System.in);

		int N = scan.nextInt();
		int M = scan.nextInt();
		int min;

		int[] arr1 = new int[M];
		int[] arr2 = new int[M];

		for (int i = 0; i < M; i++) {
			arr2[i] = scan.nextInt();
			arr1[i] = scan.nextInt();
		}

		Arrays.sort(arr1);
		Arrays.sort(arr2);

		min = Math.min(((N / 6) + 1) * arr2[0], N * arr1[0]);
		min = Math.min(min, ((N / 6)) * arr2[0] + (N % 6) * arr1[0]);

		System.out.println(min);
	}
}
