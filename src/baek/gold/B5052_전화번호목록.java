package baek.gold;

import java.util.Arrays;
import java.util.Scanner;

public class B5052_전화번호목록 {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int t = scan.nextInt();

		for (int i = 0; i < t; i++) {
			int n = scan.nextInt();
			String[] num = new String[n];
			boolean result = true;

			for (int j = 0; j < n; j++) {
				num[j] = scan.next();
			}
			Arrays.sort(num);

			for (int j = 1; j < n; j++) {
				if (num[j].startsWith(num[j - 1])) {
					result = false;
					break;
				}
			}

			if (result) {
				System.out.println("YES");
			} else {
				System.out.println("NO");
			}
		}

	}
}
