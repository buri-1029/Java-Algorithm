package baek.bronze;

import java.util.Scanner;

public class B1373_2진수8진수 {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		String N = scan.next();

		StringBuilder tmp = new StringBuilder();
		StringBuilder sb = new StringBuilder();

		for (int i = N.length() - 1; i >= 0; i--) {
			if (tmp.length() == 3) {

				sb.append(Integer.parseInt(new StringBuilder(tmp.toString()).reverse()
																			.toString(), 2));
				tmp = new StringBuilder();
			}

			tmp.append(N.charAt(i));
		}

		if (tmp.length() > 0) {
			sb.append(Integer.parseInt(new StringBuilder(tmp.toString()).reverse()
																		.toString(), 2));
		}

		System.out.println(sb.reverse());
	}
}
