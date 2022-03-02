package baek.bronze;

import java.util.Scanner;

public class B10809_알파벳찾기 {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		String S = scan.next();

		char alpha = 97;
		for (int i = 0; i < 26; i++) {
			System.out.print(S.indexOf(alpha) + " ");
			alpha += 1;
		}
	}
}
