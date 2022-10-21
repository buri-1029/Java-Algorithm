package baek.silver;

import java.util.Scanner;

public class B5582_공통부분문자열 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String str1 = sc.next();
		String str2 = sc.next();

		int[][] dp = new int[str1.length() + 1][str2.length() + 1];
		int max = 0;

		for (int i = 1; i < dp.length; i++) {
			for (int j = 1; j < dp[i].length; j++) {
				if (str1.charAt(i - 1) == str2.charAt(j - 1)) {
					dp[i][j] = dp[i - 1][j - 1] + 1;
					max = Math.max(dp[i][j], max);
				}
			}
		}

		System.out.println(max);
	}
}
