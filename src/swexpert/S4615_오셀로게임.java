package swexpert;

import java.util.Scanner;

public class S4615_오셀로게임 {
	static int N,M;
	static int[][] board;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();

		for (int tc = 1; tc <= T; tc++) {
			N = sc.nextInt();
			M = sc.nextInt();
			board = new int[N+1][N+1];

			board[N / 2][N / 2] = 2;
			board[N / 2 + 1][N / 2 + 1] = 2;
			board[N / 2][N / 2 + 1] = 1;
			board[N / 2 + 1][N / 2] = 1;

			int[] dr = { -1, 1, 0, 0, -1, -1, 1, 1 };
			int[] dc = { 0, 0, 1, -1, -1, 1, -1, 1 };

			for (int i = 0; i < M; i++) {
				int x = sc.nextInt();
				int y = sc.nextInt();
				int c = sc.nextInt();
				othello(x,y,c); // 돌 놓기(놓을 수 있는가 없는가 확인 후) 
			}
		}
	}

	private static void othello(int x, int y, int c) {
		// TODO Auto-generated method stub
		
		
	}
}
