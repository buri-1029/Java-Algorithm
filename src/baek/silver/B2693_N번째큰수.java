package baek.silver;

import java.util.Arrays;
import java.util.Scanner;

public class B2693_N번째큰수 {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int T = scan.nextInt();

		for (int t = 0; t < T; t++) {
			int[] arr = new int[10];

			for (int i = 0; i < 10; i++) {
				int num = scan.nextInt();
				arr[i] = num;
			}
			Arrays.sort(arr);

			System.out.println(arr[arr.length - 3]);
		}
	}

}
