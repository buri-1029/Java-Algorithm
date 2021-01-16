package swexpert;

import java.util.Scanner;

public class S4613_러시아국기1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();

		for (int tc = 1; tc <= T; tc++) {
			int N = sc.nextInt();
			int M = sc.nextInt();
			int ans = Integer.MAX_VALUE;
			char[][] input = new char[N][M];

			for (int i = 0; i < N; i++) {
				String str = sc.next();
				for (int j = 0; j < M; j++) {
					input[i][j] = str.charAt(j);
				}
			}

			for (int i = 0; i < N - 2; i++) {
				for (int j = i + 1; j < N - 1; j++) {
					for (int k = j + 1; k < N; k++) {
						int wcnt = 0, bcnt = 0, rcnt = 0;
						for (int r = 0; r <= i; r++) {
							for (int c = 0; c < M; c++) {
								if (input[r][c] != 'W')
									wcnt++;
							}
						}
						for (int r = i + 1; r <= k - 1; r++) {
							for (int c = 0; c < M; c++) {
								if (input[r][c] != 'B')
									bcnt++;
							}
						}
						for (int r = k; r < N; r++) {
							for (int c = 0; c < M; c++) {
								if (input[r][c] != 'R')
									rcnt++;
							}
						}
						ans = Math.min(ans, wcnt + bcnt + rcnt);
					}
				}
			}
			System.out.println("#" + tc + " " + ans);
		}
	}
}
