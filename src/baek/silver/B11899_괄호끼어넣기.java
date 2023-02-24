package baek.silver;

import java.util.Scanner;

public class B11899_괄호끼어넣기 {

	public static void main(String[] args) throws Exception {
		Scanner scan = new Scanner(System.in);

		char[] input = scan.nextLine()
						   .toCharArray();

		int cnt = 0;
		int answer = 0;

		for (char c : input) {
			if (c == '(') {
				cnt++;
			} else {
				if (cnt == 0) {
					answer++;
				} else {
					cnt--;
				}
			}

		}

		System.out.println(answer + cnt);
	}
}
