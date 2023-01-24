package baek.silver;

import java.util.Scanner;

public class B1094_막대기 {

	public static void main(String[] args) {

		Scanner scan = new Scanner(System.in);
		int X = scan.nextInt();

		int tmp = 64;
		int cnt = 0;

		while (X > 0) {
			if (tmp > X) {
				tmp /= 2;
			} else {
				X -= tmp;
				cnt++;
			}
		}

		System.out.println(cnt);
	}
}
