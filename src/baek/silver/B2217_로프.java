package baek.silver;

import java.util.Arrays;
import java.util.Scanner;

public class B2217_로프 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();

		int[] arr = new int[N];

		for (int i = 0; i < N; i++) {
			arr[i] = sc.nextInt();
		}

		Arrays.sort(arr);

		int max = Integer.MIN_VALUE;

		for (int i = 0; i < N; i++) {
			max = Math.max(max, arr[i] * (N - i));
		}

		System.out.println(max);
	}
}
