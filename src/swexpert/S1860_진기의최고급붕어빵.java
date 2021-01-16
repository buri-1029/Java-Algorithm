package swexpert;

import java.util.Arrays;
import java.util.Scanner;
/**greedy 알고리즘*/
public class S1860_진기의최고급붕어빵 {
	static int N, M, K, max = Integer.MIN_VALUE;
	static int[] TIME;
	static int[] CNT;
	static boolean res;
	static boolean check;

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();

		for (int tc = 1; tc <= T; tc++) {
			N = sc.nextInt();
			M = sc.nextInt();
			K = sc.nextInt();
			res = true;
			check = false;

			TIME = new int[N];
			for (int n = 0; n < N; n++) {
				TIME[n] = sc.nextInt();
				if (max < TIME[n])
					max = TIME[n];
				if (TIME[n] == 0)
					check = true;
			}

			Arrays.sort(TIME);
			CNT = new int[max + 1];
			int cnt = 0;

			if (check) {
				res = false;
			} else {
				for (int i = 1; i <= max; i++) {
					for (int j = 0; j < N; j++) {
						if (i == TIME[j])
							cnt--;
					}
					if (i % M == 0) {
						cnt += K;
						CNT[i] = cnt;
					} else {
						CNT[i] = cnt;
					}
				}

				for (int i = 1; i <= max; i++) {
					if (CNT[i] < 0) {
						res = false;
						break;
					}
				}
			}
			System.out.println("#" + tc + " " + (res ? "Possible" : "Impossible"));
		}
	}
}
