package baek.silver;

import java.util.Arrays;
import java.util.Scanner;

public class B18310_안테나 {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int N = scan.nextInt();

		int[] arr = new int[N];

		for (int i = 0; i < N; i++) {
			arr[i] = scan.nextInt();
		}

		Arrays.sort(arr);

		if (N % 2 == 0) {
			System.out.println(arr[N / 2 - 1]);
		} else {
			System.out.println(arr[N / 2]);
		}
	}
}
