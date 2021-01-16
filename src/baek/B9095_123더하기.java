package baek;

import java.util.Scanner;

public class B9095_123더하기 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		
		//동적으로 생성시키니 메모리 초과가 되서 정적으로 선언
		int[] dp = new int[11]; 

		dp[1] = 1; // 1을 넣을 경우 경우의 수 1가지(1)
		dp[2] = 2; // 2를 넣을 경우 경우의 수 2가지(1+1, 2)
		dp[3] = 4; // 3을 넣을 경우 경우의 수 3가지 (1+1+1, 1+2, 2+1, 3)

		for (int tc = 1; tc <= T; tc++) {
			int n = sc.nextInt();
			
			for (int i = 4; i <= n; i++) {
				dp[i] =  dp[i - 1]+ dp[i - 2] + dp[i - 3];
			}
			System.out.println(dp[n]);
		}
	}
}
