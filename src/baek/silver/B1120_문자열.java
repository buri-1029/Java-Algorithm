package baek.silver;

import java.util.Scanner;

public class B1120_문자열 {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);

		String a = scanner.next();
		String b = scanner.next();

		int answer = a.length();

		for (int i = 0; i < b.length() - a.length() + 1; i++) {
			int tmp = 0;

			for (int j = 0; j < a.length(); j++) {
				if (a.charAt(j) != b.charAt(j + i)) {
					tmp++;
				}
			}
			if (answer > tmp) {
				answer = tmp;
			}
		}

		System.out.println(answer);
	}
}
