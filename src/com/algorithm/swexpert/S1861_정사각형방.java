package com.algorithm.swexpert;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class S1861_정사각형방 {
	static int T, N, tmp, max, max_index;
	static int[] dr = { 0, 0, -1, 1 };
	static int[] dc = { -1, 1, 0, 0 };
	static int[][] arr;

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		T = Integer.parseInt(br.readLine().trim());
		for (int tc = 1; tc <= T; tc++) {
			N = Integer.parseInt(br.readLine().trim());
			arr = new int[N][N];
			max = 0; tmp = 0;
			max_index = Integer.MAX_VALUE;

			for (int i = 0; i < N; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine().trim(), " ");
				for (int j = 0; j < N; j++) {
					arr[i][j] = Integer.parseInt(st.nextToken());
				}
			}

			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					tmp = recursive(i, j, arr[i][j], 1);
					if (max < tmp) {
						max = tmp;
						max_index = arr[i][j];
					}
					if (max == tmp)
						max_index = Math.min(max_index, arr[i][j]);
				}
			}
			System.out.println("#" + tc + " " + max_index + " " + max);
		}
	}

	private static int recursive(int i, int j, int k, int cnt) {
		// TODO Auto-generated method stub
		for (int d = 0; d < 4; d++) {
			if (i + dr[d] >= 0 && i + dr[d] < N && j + dc[d] >= 0 && j + dc[d] < N) {
				if (arr[i + dr[d]][j + dc[d]] == k + 1) {
					return recursive(i + dr[d], j + dc[d], k + 1, cnt + 1);
				}
			}
		}
		return cnt;
	}
}
