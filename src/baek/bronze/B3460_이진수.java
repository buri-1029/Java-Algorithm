package baek.bronze;

import java.util.ArrayList;
import java.util.Scanner;

public class B3460_이진수 {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int T = scan.nextInt();

		for (int t = 0; t < T; t++) {
			int n = scan.nextInt();

			ArrayList<Integer> index = new ArrayList<>();
			while (true) {
				if (n == 0 || n == 1) {
					index.add(n % 2);
					break;
				}

				index.add(n % 2);
				n /= 2;
			}

			for (int i = 0; i < index.size(); i++) {
				if (index.get(i) == 1) {
					System.out.print(i + " ");
				}
			}
		}
	}

}
