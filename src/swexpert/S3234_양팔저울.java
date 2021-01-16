package swexpert;

import java.util.Scanner;

public class S3234_양팔저울 {
	static int N;
	static int cnt, sum;
	static int[] num, sel;
	static boolean[] visit;

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for (int tc = 1; tc <= T; tc++) {
			N = sc.nextInt();
			num = new int[N];
			sel = new int[N];
			visit = new boolean[N];
			sum = 0;
			cnt = 0;

			for (int i = 0; i < N; i++) {
				num[i] = sc.nextInt();

			}
			permutation(0);
			System.out.println("#" + tc + " " + cnt);
		}
	}

	// N개 순열 뽑기
	private static void permutation(int idx) {
		// TODO Auto-generated method stub
		if (idx == N) {
			dfs(0, 0, 0); // 뽑을 때마다 무게 추 올리는 방법 검색
			return;
		}

		for (int i = 0; i < N; i++) {
			if (visit[i] != true) {
				visit[i] = true;
				sel[idx] = num[i];
				permutation(idx + 1);
				visit[i] = false;
			}
		}
	}

	private static void dfs(int i, int left, int right) {
		if (i == N) { 
			cnt++;
			return;
		}
		
		dfs(i + 1, sel[i] + left, right); // 왼쪽 저울 합과 함께 검색
		sum = sel[i] + right; 			 // 오른쪽 저울 합
		if (sum <= left)  		// 오른쪽 저울 합이 이전 왼쪽 저울 합보다 작으면 
			dfs(i + 1, left, sum); // 또 다른 무게 추 올리는 방법 검색 가능

	}
}
