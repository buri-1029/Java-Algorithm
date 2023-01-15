package baek.bronze;

import java.util.Scanner;

public class B1357_뒤집기덧셈 {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		String X = scan.next();
		String Y = scan.next();

		int sum = Integer.parseInt(new StringBuilder(X).reverse()
													   .toString()) +
			Integer.parseInt(new StringBuilder(Y).reverse()
												 .toString());

		System.out.println(Integer.parseInt(new StringBuilder(String.valueOf(sum)).reverse()
																				  .toString()));
	}
}
