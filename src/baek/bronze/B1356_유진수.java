package baek.bronze;

import java.util.Scanner;

public class B1356_유진수 {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		String str = scan.next();
		String answer = "NO";

		if (str.length() > 1) {
			for (int i = 1; i < str.length(); i++) {
				int a = 1, b = 1;

				for (int j = 0; j < i; j++) {
					a *= (str.charAt(j) - '0');
				}

				for (int j = i; j < str.length(); j++) {
					b *= (str.charAt(j) - '0');
				}

				if (a == b) {
					answer = "YES";
					break;
				}
			}
		}

		System.out.println(answer);
	}
}
