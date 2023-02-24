package baek.silver;

import java.util.Scanner;

public class B13413_오셀로재배치 {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int tc = scan.nextInt();

		for (int t = 0; t < tc; t++) {
			int n = scan.nextInt();
			int w_cnt = 0,
				b_cnt = 0;

			String start = scan.next();
			String want = scan.next();

			for (int i = 0; i < n; i++) {
				if (start.charAt(i) != want.charAt(i)) {
					if (start.charAt(i) == 'W') {
						b_cnt++;
					} else {
						w_cnt++;
					}
				}
			}

			System.out.println(Math.max(b_cnt, w_cnt));
		}
	}
}
