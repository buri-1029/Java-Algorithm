package baek.bronze;

import java.util.ArrayList;
import java.util.Scanner;

public class B9506_약수들의합 {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);

		while (true) {
			int n = scan.nextInt();
			if (n == -1) {
				break;
			}

			ArrayList<Integer> list = new ArrayList<>();
			int sum = 0;

			for (int i = 1; i <= n; i++) {
				if (n % i == 0 && n != i) {
					sum += i;
					list.add(i);
				}
			}

			StringBuilder answer = new StringBuilder(n + "");

			if (sum == n) {
				answer.append(" =");
				for (int num : list) {
					answer.append(" ")
						  .append(num)
						  .append(" +");
				}
			} else {
				answer.append(" is NOT perfect.");
			}

			System.out.println(
				answer.charAt(answer.length() - 1) == '+' ? answer.substring(0, answer.length() - 2)
					: answer.toString());
		}
	}
}
