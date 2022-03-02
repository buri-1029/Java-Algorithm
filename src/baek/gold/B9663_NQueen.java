package baek.gold;

import java.util.Scanner;

public class B9663_NQueen {

	/**
	 * ! 퀸 N개를 서로 공격할 수 없게 놓는 경우의 수
	 */
	static int N, cnt = 0;
	static int[] col;

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		col = new int[N];

		dfs(0);
		System.out.println(cnt);
	}

	private static void dfs(int row) {
		// row : 현재의 행 위치
		if (row == N) {
			cnt++; // 퀸을 놓을 수 있는 개수 증가
		} else {
			// 가능한 선택지 0 ~ N-1
			for (int i = 0; i < N; i++) {
				col[row] = i;
				if (isPossible(row)) { // 퀸을 i에 놓을 수 있는가?
					dfs(row + 1); // 그렇다면 퀸을 그 자리에 넣고 다음 행으로,
				}
				// 일차원 배열로 퀸의 위치로 관리하므로 시도했던 선택지 열 값을 되도릴 필요가 없다.
			}
		}
	}

	// row행의 퀸을 놓는 것이 가능한지 확인 : 놓을 수 있다면 true, 없다면 false
	private static boolean isPossible(int row) {
		for (int i = 0; i < row; i++) {
			// i번째 퀸의 위치와 row 위치의 퀸이 같은 일직선 상에 있는 경우
			// i번째 퀸의 위치와 row 위치의 퀸이 대각선 상에 있는 경우
			if (col[i] == col[row] || Math.abs(i - row) == Math.abs(col[i] - col[row])) {
				return false;
			}
		}
		return true;
	}
}
