package baek.bronze;

import java.util.Scanner;

public class B3460_이진수 {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int T = scan.nextInt();

		for (int t = 0; t < T; t++) {
			int n = scan.nextInt();

			StringBuilder tmp = new StringBuilder();
			while (true) {
				if (n == 0 || n == 1) {
					tmp.append(n % 2);
					break;
				}

				tmp.append(n % 2);
				n /= 2;
			}

			String[] arr = tmp.toString()
							  .split("");
			for (int i = 0; i < arr.length; i++) {
				if (arr[i].equals("1")) {
					System.out.print(i + " ");
				}
			}
		}
	}

}
