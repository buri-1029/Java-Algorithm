package com.algorithm.baek;

import java.util.Scanner;

public class B2615_오목 {
	static int[][] board = new int[19 + 1][19 + 1];
	// 우상, 우, 우하, 하
	static int[] dr = { -1, 0, 1, 1 };
	static int[] dc = { 1, 1, 1, 0 };
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		for (int r = 1; r <= 19; r++) {
			for (int c = 1; c <= 19; c++) {
				board[r][c] = sc.nextInt();
			}
		}
		
		boolean flag = false;
		for (int r = 1; r <= 19; r++) {
			for (int c = 1; c <= 19; c++) {
				
				//	1 : 검은돌  / 2 : 흰돌
				if (board[r][c] == 1 || board[r][c] == 2) {
					// 우상, 우, 우하, 하  방향으로 돌면서
					for (int k = 0; k < 4; k++) {
						int nr = r + dr[k];
						int nc = c + dc[k];
						int cnt = 1; // 바둑알 개수 (현재 하나)
						
						// 범위 안에 있고, 이 전의 바둑알의 색과 계속 같을 때까지 
						while (check(nr, nc) && board[nr][nc] == board[r][c]) {
							nr += dr[k];
							nc += dc[k];
							cnt++;
						}
						// 오목이면
						if(cnt == 5) { 
							
							/** ************ **/
							// 뒤로 돌아가서 오목인지 확인
							int bCnt=1;
							
							nr = nr + (dr[k]*-1);
							nc = nc + (dc[k]*-1);
							
							while(check(nr,nc)&&board[nr][nc]==board[r][c]) {
								
								nr += (dr[k]*-1);
								nc += (dc[k]*-1);
								bCnt++;
							}
							if(bCnt > 6) continue;
							flag = true;
							System.out.println(board[r][c]);
							System.out.println(r+" "+c);
						}
					}
				}
			}
		}
		if(!flag) {
			System.out.println(0);
		}
	}
	
	// 바둑알이 바둑판 범위 안에 있는지 확인
	private static boolean check(int nr, int nc) {
		if(nr>0&&nr<=19&&nc>0&&nc<=19) {
			return true;
		}
		return false;
	}
}
