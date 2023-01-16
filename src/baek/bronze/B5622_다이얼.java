package baek.bronze;

import java.util.Scanner;

public class B5622_다이얼 {

	public static void main(String[] args) {

		Scanner scan = new Scanner(System.in);
		String str = scan.nextLine();

		int cnt = 0;

		for (int i = 0; i < str.length(); i++) {

			switch (str.charAt(i)) {
				case 'A', 'B', 'C' -> cnt += 3;
				case 'D', 'E', 'F' -> cnt += 4;
				case 'G', 'H', 'I' -> cnt += 5;
				case 'J', 'K', 'L' -> cnt += 6;
				case 'M', 'N', 'O' -> cnt += 7;
				case 'P', 'Q', 'R', 'S' -> cnt += 8;
				case 'T', 'U', 'V' -> cnt += 9;
				case 'W', 'X', 'Y', 'Z' -> cnt += 10;
			}
		}

		System.out.print(cnt);
	}
}
