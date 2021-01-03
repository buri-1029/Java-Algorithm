package com.algorithm.baek;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class B7569_토마토 {
	static int C, R, H, ANS; // 가로칸 수, 세로칸 수, 상자의 수
	static int[][][] tomato;
	static boolean[][][] visit;
	static Queue<Info> queue = new LinkedList<>();
	static int[] dr = {1, -1, 0, 0, 0, 0};
	static int[] dc = {0, 0, 1, -1, 0, 0};
	static int[] dh = {0, 0, 0, 0, 1, -1};
	
	static class Info{
		int h, r, c, d;

		public Info(int h, int r, int c, int d) {
			super();
			this.h = h;
			this.r = r;
			this.c = c;
			this.d = d;
		}
	}
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		C = sc.nextInt();
		R = sc.nextInt();
		H = sc.nextInt();
		
		tomato = new int[H][R][C];
		visit = new boolean[H][R][C];
		
		for(int i = 0; i < H; i++) {
			for(int j = 0; j < R; j++) {
				for(int k = 0; k < C; k++) {
					tomato[i][j][k] = sc.nextInt();
					if(tomato[i][j][k] == 1) {
						queue.add(new Info(i, j, k, 0));
						visit[i][j][k] = true;
					}
				}
			}
		}
		
		bfs();
		
		boolean flag = true;
		for(int i = 0; i < H; i++) {
			for(int j = 0; j < R; j++) {
				for(int k = 0; k < C; k++) {
					if(!visit[i][j][k] && tomato[i][j][k] == 0) {
						flag = false;
					}
				}
			}
		}
		
		if(flag) System.out.println(ANS);
		else System.out.println(-1);
	}
	private static void bfs() {
		while(!queue.isEmpty()) {
			Info cur = queue.poll();
			ANS = Math.max(ANS, cur.d);
			
			for(int d = 0; d < 6; d++) {
				int nr = cur.r + dr[d];
				int nc = cur.c + dc[d];
				int nh = cur.h + dh[d];
				
				if(nr < 0 || nr >= R || nc < 0 || nc >= C || nh < 0 || nh >= H) continue;
				if(tomato[nh][nr][nc] != 0 || visit[nh][nr][nc]) continue;
				
				queue.add(new Info(nh, nr, nc, cur.d + 1));
				visit[nh][nr][nc] = true;
			}
		}
	}
}
