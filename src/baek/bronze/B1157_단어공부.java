package baek.bronze;

import java.util.Scanner;

/*
 * 백준 - 구현
 *
 */
public class B1157_단어공부 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String str = sc.next();
		str = str.toUpperCase();

		int[] alpha = new int[26];

		for (int i = 0; i < str.length(); i++) {
			alpha[str.charAt(i) - 'A']++;
		}

		int max = -1;
		char ch = '?';
		for (int i = 0; i < alpha.length; i++) {
			if (alpha[i] > max) {
				max = alpha[i];
				ch = (char) (i + 65);
			} else if (alpha[i] == max) {
				ch = '?';
			}
		}
		System.out.println(ch);
	}
}
