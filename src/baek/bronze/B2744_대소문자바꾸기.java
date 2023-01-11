package baek.bronze;

import java.util.Scanner;

public class B2744_대소문자바꾸기 {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		String str = scan.next();

		String answer = "";

		for (int i = 0; i < str.length(); i++) {
			if (Character.isUpperCase(str.charAt(i))) {
				answer += Character.toLowerCase(str.charAt(i));
			} else if (Character.isLowerCase(str.charAt(i))) {
				answer += Character.toUpperCase(str.charAt(i));
			}
		}

		System.out.println(answer);
	}
}
