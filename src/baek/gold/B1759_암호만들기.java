package baek.gold;

import java.util.Arrays;
import java.util.Scanner;

public class B1759_암호만들기 {

	static String[] alpa, select;

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int L = scan.nextInt();
		int C = scan.nextInt();
		alpa = new String[C];
		select = new String[L];

		for (int i = 0; i < C; i++) {
			alpa[i] = scan.next();
		}
		Arrays.sort(alpa);

		combination(0, 0);

	}

	private static void combination(int idx, int k) {
		if (k == select.length) {
			StringBuilder tmp = new StringBuilder();
			for (String s : select) {
				tmp.append(s);
			}

			if (checkNumber(tmp.toString())) {
				System.out.println(tmp);
			}

			return;
		}

		if (idx == alpa.length) {
			return;
		}

		select[k] = alpa[idx];
		combination(idx + 1, k + 1);
		combination(idx + 1, k);
	}

	private static boolean checkNumber(String tmp) {
		int a = 0, b = 0;

		for (int i = 0; i < tmp.length(); i++) {
			switch (tmp.charAt(i)) {
				case 'a', 'e', 'i', 'o', 'u' -> a++;
				default -> b++;
			}
		}

		return a >= 1 && b >= 2;
	}

}
