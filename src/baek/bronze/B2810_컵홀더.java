package baek.bronze;

import java.util.Scanner;

public class B2810_컵홀더 {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int N = scan.nextInt();
		String str = scan.next();

		int cnt = 1;

		for (int i = 0; i < N; i++) {
			char ch = str.charAt(i);

			if (ch == 'S') {
				cnt++;
			} else if (ch == 'L') {
				i++;
				cnt++;
			}
		}

		System.out.println(Math.min(cnt, N));
	}
}
