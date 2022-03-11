package baek.silver;

import java.util.Scanner;

public class B14912_숫자빈도수 {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int n = scan.nextInt();
		int d = scan.nextInt();
		int answer = 0;

		for (int i = 0; i < n; i++) {
			String strNum = Integer.toString(i + 1);
			for (int j = 0; j < strNum.length(); j++) {
				if (strNum.charAt(j) - '0' == d) {
					answer++;
				}
			}
		}

		System.out.println(answer);

	}

}
