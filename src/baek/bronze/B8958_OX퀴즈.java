package baek.bronze;

import java.util.Scanner;

public class B8958_OX퀴즈 {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int T = scan.nextInt();

		for (int t = 0; t < T; t++) {
			String str = scan.next();
			int score = 0;
			int index = 0;

			for (int i = 0; i < str.length(); i++) {
				if (str.charAt(i) == 'O') {
					score += ++index;
				} else if (str.charAt(i) == 'X') {
					index = 0;
				}
			}
			System.out.println(score);
		}
	}

}
