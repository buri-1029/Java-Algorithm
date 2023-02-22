package baek.silver;

import java.util.Scanner;

public class B1213_팰린드롬만들기 {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		String str = scan.next();

		int[] arr = new int[26];

		for (int i = 0; i < str.length(); i++) {
			arr[str.charAt(i) - 'A']++;
		}

		int cnt = 0;
		int center = 0;

		for (int i = 0; i < 26; i++) {
			if (arr[i] % 2 != 0) {
				center = i;
				cnt++;
			}
		}

		if (cnt > 1 || (cnt == 1 && str.length() % 2 == 0)) {
			System.out.print("I'm Sorry Hansoo");
			return;
		}

		StringBuilder answer = new StringBuilder();

		for (int i = 0; i < 26; i++) {
			answer.append(String.valueOf((char) (i + 'A'))
								.repeat(Math.max(0, arr[i] / 2))); // java 11
		}

		StringBuilder tmp = new StringBuilder(answer.toString());

		if (cnt == 1) {
			answer.append((char) (center + 'A'));
		}

		System.out.println(answer.toString() + tmp.reverse());
	}
}
