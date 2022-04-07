package baek.silver;

import java.util.Scanner;

public class B1789_수들의합 {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		long S = scan.nextLong();
		long n = 0;

		while (n * (n + 1) <= S * 2) {
			n++;
		}

		System.out.println(n - 1);
	}
}
