package baek.silver;

import java.util.Scanner;

/* 다시 해보기 */
public class B11052_카드구매하기 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();

		// 가격 저장할 배열
		int[] p = new int[n + 1];
		// n개의 카드를 구매하기 위해 지불해야 하는 금액의 최대값 저장할 배열
		int[] dp = new int[n + 1];

		for (int i = 1; i < n + 1; i++) {
			p[i] = sc.nextInt();
		}

		for (int i = 1; i < n + 1; i++) {
			for (int j = 1; j < i + 1; j++) {
				dp[i] = Math.max(dp[i], dp[i - j] + p[j]);
			}
		}
		System.out.println(dp[n]);
	}
}
