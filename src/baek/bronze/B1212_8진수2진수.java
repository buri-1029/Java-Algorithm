package baek.bronze;

import java.util.Scanner;

// 8진수 3자리는 2진수 1자리가 된다는 것 이용
public class B1212_8진수2진수 {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		String N = scan.next();

		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < N.length(); i++) {
			String a = Integer.toBinaryString(N.charAt(i) - '0');

			if (a.length() == 2 && i != 0) {
				a = "0" + a;
			} else if (a.length() == 1 && i != 0) {
				a = "00" + a;
			}

			sb.append(a);
		}

		System.out.println(sb);
	}
}
