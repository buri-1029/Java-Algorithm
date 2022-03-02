package baek.bronze;

import java.util.Scanner;

public class B11720_숫자의합 {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int N = scan.nextInt();
		String str = scan.next();

		int sum = 0;
		for (int i = 0; i < N; i++) {
			sum += str.charAt(i) - '0';
		}

		System.out.println(sum);
	}

}
