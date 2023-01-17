package baek.bronze;

import java.util.Scanner;

public class B1193_분수찾기 {

	public static void main(String[] args) {

		Scanner scan = new Scanner(System.in);
		int X = scan.nextInt();

		int cnt = 1, sum = 0;

		while (true) {

			if (X <= sum + cnt) {

				if (cnt % 2 == 1) {
					System.out.print((cnt - (X - sum - 1)) + "/" + (X - sum));
					break;
				} else {
					System.out.print((X - sum) + "/" + (cnt - (X - sum - 1)));
					break;
				}

			} else {
				sum += cnt;
				cnt++;
			}
		}
	}
}
