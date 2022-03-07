package baek.bronze;

import java.util.Scanner;

public class B10818_최소최대 {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int N = scan.nextInt();

		int max = Integer.MIN_VALUE;
		int min = Integer.MAX_VALUE;
		for (int i = 0; i < N; i++) {
			int input = scan.nextInt();

			max = Math.max(max, input);
			min = Math.min(min, input);
		}

		System.out.println(min + " " + max);
	}

}
