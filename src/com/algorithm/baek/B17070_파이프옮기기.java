package com.algorithm.baek;

import java.util.Scanner;

public class B17070_파이프옮기기 {
	static int N, res = 0;
	static int state = 0; // 0:가로 1:세로 2:대각선
	static int[][] arr;

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		arr = new int[N][N];

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				arr[i][j] = sc.nextInt();
			}
		}
		
		// 파이프를 이동시키는 방법의 개수를 구하는 것이니깐 dfs 사용.
		dfs(0, 1, state); // 파이프 끝 쪽이 있는 좌표 부터 시작, 상태는 가로(0)
		System.out.println(res);
	}

	private static void dfs(int r, int c, int state) {
		// TODO Auto-generated method stub
		if (r == N - 1 && c == N - 1) {
			res++;
			return;
		}
		
		// state -> 0:가로 1:세로 2:대각선
		// 동시에 경우의 수를 찾아봐야 함.
		
		// 가로로 이동 가능한 경우 -> 가로, 대각선일 때  		
		if (state != 1 && isRange(r, c + 1) && arr[r][c + 1] == 0) {
			dfs(r, c + 1, 0); 
		}
		
		// 세로로 이동 가능한 경우 -> 세로, 대각선일 때
		if (state != 0 && isRange(r + 1, c) && arr[r + 1][c] == 0) {
			dfs(r + 1, c, 1);
		}
		
		// 대각선으로 이동 가능한 경우 -> 모두
		if (isRange(r + 1, c + 1) && arr[r + 1][c + 1] == 0 && arr[r][c + 1] == 0 && arr[r + 1][c] == 0) {
			dfs(r + 1, c + 1, 2);
		}

	}

	private static boolean isRange(int r, int c) {
		// TODO Auto-generated method stub
		if (r >=0 && r < N && c >= 0 && c < N) {
			return true;
		}
		return false;
	}
}
