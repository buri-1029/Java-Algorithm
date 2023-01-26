package baek.silver;

import java.util.Arrays;
import java.util.Scanner;

public class B1037_약수 {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int cnt = scan.nextInt();

		int[] arr = new int[cnt];

		for (int i = 0; i < cnt; i++) {
			arr[i] = scan.nextInt();
		}

		Arrays.sort(arr);

		if (cnt % 2 == 0) {
			System.out.println(arr[0] * arr[cnt - 1]);
		} else {
			System.out.println(arr[cnt / 2] * arr[cnt / 2]);
		}
	}
}
