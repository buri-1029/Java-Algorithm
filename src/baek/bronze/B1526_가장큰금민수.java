package baek.bronze;

import java.util.Scanner;

public class B1526_가장큰금민수 {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int N = scan.nextInt();

		for (int i = N; i >= 4; i--) {
			boolean flag = true;
			int tmp = i;

			while (tmp != 0) {
				if (tmp % 10 == 4 || tmp % 10 == 7) {
					tmp /= 10;
				} else {
					flag = false;
					break;
				}
			}

			if (flag) {
				System.out.println(i);
				break;
			}
		}
	}
}
