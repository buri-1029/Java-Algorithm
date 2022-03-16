package baek.silver;

import java.util.Scanner;

public class B1439_뒤집기 {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		String str = scan.next();

		char[] arr = str.toCharArray();
		int zero = 0, one = 0;

		if (arr[0] == '0') {
			zero++;
		} else {
			one++;
		}

		for (int i = 1; i < arr.length; i++) {
			if (arr[i - 1] != arr[i]) {
				if (arr[i] == '0') {
					zero++;
				}

				if (arr[i] == '1') {
					one++;
				}
			}

		}

		System.out.println(Math.min(zero, one));

	}
}
