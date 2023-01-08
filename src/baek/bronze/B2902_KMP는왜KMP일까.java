package baek.bronze;

import java.util.Scanner;

public class B2902_KMP는왜KMP일까 {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		String str = scan.next();

		String answer = "";

		for (int i = 0; i < str.length(); i++) {
			if (i == 0 || str.charAt(i - 1) == '-') {
				answer += str.charAt(i);
			}
		}

		System.out.println(answer);
	}
}
