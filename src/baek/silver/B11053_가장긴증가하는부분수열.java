package baek.silver;

import java.util.Scanner;
/*
 * 다시 해보기(st-lab 블로그 참고)
 * - 최장 증가 부분 수열(LIS) : 주어진 수열에서 오름차순으로 구성 가능한 원소들을 선택하여 최대 길이를 찾아내는 것
 */

public class B11053_가장긴증가하는부분수열 {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int N = scan.nextInt();

		int[] arr = new int[N];
		int[] dp = new int[N];

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

		System.out.println(max);
	}
}
