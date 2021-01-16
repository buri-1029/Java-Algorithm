package swexpert;

import java.util.Scanner;
/*
 *  with 강사님
 *  다시 해보기 
 */
public class S2115_벌꿀채취 {
	static int N, M, C;
	static int[][] bee; // 벌통
	static int[][] maxbee; // 벌통

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();

		for (int tc = 1; tc <= T; tc++) {
			N = sc.nextInt();
			M = sc.nextInt();
			C = sc.nextInt();

			bee = new int[N][N];
			maxbee = new int[N][N];

			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					bee[i][j] = sc.nextInt();
				}
			}
			System.out.println("#" + tc + " " + getMaxBenefit());
		}
	}

	private static int getMaxBenefit() {
		makeMaxMap();
		return processCombination();
	}

	private static void makeMaxMap() {
		for (int i = 0; i < N; i++) {
			for (int j = 0; j <= N - M; j++) {
				makeMaxSubset(i, j, 0, 0, 0);
			}
		}

	}
	// powSum을 시작위치에 저장,
	private static void makeMaxSubset(int i, int j, int cnt, int sum, int powSum) {
		
		if(sum > C) return;
		if(cnt == M) {
			if(maxbee[i][j - M] < powSum) maxbee[i][j - M] = powSum;
			return;
		}
		
		// 선택
		makeMaxSubset(i, j + 1, cnt + 1, sum + bee[i][j], powSum + bee[i][j]*bee[i][j]);
		// 비선택
		makeMaxSubset(i, j + 1, cnt + 1, sum, powSum);
	}

	private static int processCombination() {
		int max = 0, aBenefit = 0, bBenefit = 0;
		for(int i = 0; i < N; i++) {
			for(int j = 0; j <= N - M; j++) {
				aBenefit = maxbee[i][j];
				// 일꾼 B 선택
				// 같은 행
				bBenefit = 0;
				for(int j2 = j + N; j2 <= N - M; j2++) {
					if(bBenefit < maxbee[i][j2]) bBenefit = maxbee[i][j2];
				}
				// 다른 행
				for(int i2 = i + 1; i2 < N; i2++) {
					for(int j2 = 0; j2 <= N - M; j2++) {
						if(bBenefit < maxbee[i2][j2]) bBenefit = maxbee[i2][j2];
					}
				}
				if(max < aBenefit + bBenefit) max = aBenefit + bBenefit;
			}
		}
		return max;
	}
}
