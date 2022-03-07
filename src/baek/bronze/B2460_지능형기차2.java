package baek.bronze;

import java.util.Scanner;

public class B2460_지능형기차2 {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);

		int cur = 0;
		int answer = 0;
		for (int i = 0; i < 10; i++) {
			int n = scan.nextInt();
			int m = scan.nextInt();

			cur += (-n) + m;
			answer = Math.max(answer, cur);
		}

		System.out.println(answer);
	}

}
