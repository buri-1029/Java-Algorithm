package baek.bronze;

import java.util.Arrays;
import java.util.Scanner;

public class B14467_소가길을건너간이유1 {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);

		int n = scan.nextInt();
		int[] arr = new int[11];
		int answer = 0;

		Arrays.fill(arr, -1);

		for (int i = 0; i < n; i++) {
			int num = scan.nextInt();
			int pos = scan.nextInt();

			if (arr[num] == -1) {
				arr[num] = pos;
			} else if (arr[num] != pos) {
				arr[num] = pos;
				answer += 1;
			}
		}

		System.out.println(answer);
	}
}
