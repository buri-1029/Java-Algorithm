package baek.silver;

import java.util.Scanner;
/*
 * 다시 해보기(st-lab 블로그 참고)
 * - 최장 증가 부분 수열(LIS) : 주어진 수열에서 오름차순으로 구성 가능한 원소들을 선택하여 최대 길이를 찾아내는 것
 */

public class B11053_가장긴증가하는부분수열 {

	static int[] arr;
	static Integer[] dp;

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int N = scan.nextInt();

		arr = new int[N];
		dp = new Integer[N];

		for (int i = 0; i < N; i++) {
			arr[i] = scan.nextInt();
		}

		// Bottom-Up(반복문) 방식
		for (int i = 0; i < N; i++) {
			dp[i] = 1;

			// 0 ~ i 이전 원소들 탐색
			for (int j = 0; j < i; j++) {

				// j번째 원소가 i번째 원소보다 작으면서 i번째 dp가 j번째 dp+1 값보다 작은경우
				if (arr[j] < arr[i] && dp[i] < dp[j] + 1) {
					dp[i] = dp[j] + 1;    // j번째 원소의 +1 값이 i번째 dp가 된다.
				}
			}
		}

		int max = -1;
		for (int i = 0; i < N; i++) {
			max = Math.max(dp[i], max);
		}

		// Top-Down(재귀) 방식
		/*
		 * 		// 0 ~ N-1 까지 모든 부분수열 탐색
		 * 		for (int i = 0; i < N; i++) {
		 * 			LIS(i);
		 *      }
		 *
		 * 		int max = dp[0];
		 * 		for(int i = 1; i < N; i++) {
		 *			max = Math.max(max, dp[i]);
		 *		}
		 */

		System.out.println(max);
	}

	public static int LIS(int N) {

		// 만약 탐색하지 않던 위치의 경우
		if (dp[N] == null) {
			dp[N] = 1;    // 1로 초기화

			// N-1 부터 0까지중 N보다 작은 값들을 찾으면서 재귀호출.
			for (int i = N - 1; i >= 0; i--) {
				if (arr[i] < arr[N]) {
					dp[N] = Math.max(dp[N], LIS(i) + 1);
				}
			}
		}

		return dp[N];
	}
}
