package baek.bronze;

import java.util.Scanner;

public class B10820_문자열분석 {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);

		while (scan.hasNextLine()) {
			String str = scan.nextLine();
			int a = 0;
			int b = 0;
			int c = 0;
			int d = 0;

			for (int i = 0; i < str.length(); i++) {
				if (Character.isLowerCase(str.charAt(i))) {
					a++;
				} else if (Character.isUpperCase(str.charAt(i))) {
					b++;
				} else if (Character.isDigit(str.charAt(i))) {
					c++;
				} else if (str.charAt(i) == ' ') {
					d++;
				}
			}

			System.out.println(a + " " + b + " " + c + " " + d);
		}
	}
}
