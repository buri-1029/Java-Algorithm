package baek.bronze;

import java.util.Scanner;

public class B2577_숫자의개수 {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int n = 1;

		for (int i = 0; i < 3; i++) {
			n *= scan.nextInt();
		}

		int[] arr = new int[10];
		String str_n = String.valueOf(n);

		for (int i = 0; i < str_n.length(); i++) {
			arr[str_n.charAt(i) - '0']++;
		}

		for (int num : arr) {
			System.out.println(num);
		}
	}
}
