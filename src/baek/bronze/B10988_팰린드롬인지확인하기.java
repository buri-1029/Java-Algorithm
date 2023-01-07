package baek.bronze;

import java.util.Scanner;

public class B10988_팰린드롬인지확인하기 {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		String str = scan.next();

		int answer = 1;
		for (int i = 0; i < str.length() / 2; i++) {
			if (str.charAt(i) != str.charAt(str.length() - 1 - i)) {
				answer = 0;
				break;
			}
		}

		System.out.println(answer);
	}
}
