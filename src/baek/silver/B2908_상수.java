package baek.silver;

import java.util.Scanner;

public class B2908_상수 {

	public static void main(String[] args) {

		Scanner scan = new Scanner(System.in);

		int A = scan.nextInt();
		int B = scan.nextInt();

		scan.close();

		A = Integer.parseInt(new StringBuilder().append(A)
												.reverse()
												.toString());
		B = Integer.parseInt(new StringBuilder().append(B)
												.reverse()
												.toString());

		System.out.print(Math.max(A, B));

	}
}
