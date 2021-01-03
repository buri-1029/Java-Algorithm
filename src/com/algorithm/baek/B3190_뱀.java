package com.algorithm.baek;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

public class B3190_뱀 {

	static int N, K, L,TIME = 0;
	static int[][] board;
	static Change[] change;
	static int[] dr = { 0, 0, 1, -1 }; // 동서남북
	static int[] dc = { 1, -1, 0, 0 };

	static class Loc {
		int r, c;

		public Loc(int r, int c) {
			super();
			this.r = r;
			this.c = c;
		}
	}

	static class Change {
		int x;
		char d;

		public Change(int x, char d) {
			super();
			this.x = x;
			this.d = d;
		}
	}

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		N = Integer.parseInt(br.readLine()); // 보드의 크기
		board = new int[N + 1][N + 1];

		board[1][1] = 1; // 뱀 설정

		K = Integer.parseInt(br.readLine()); // 사과의 개수
		for (int i = 0; i < K; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			board[x][y] = 2; // 사과 위치
		}

		L = Integer.parseInt(br.readLine()); // 뱀 방향 변환 횟수
		change = new Change[L];
		for (int i = 0; i < L; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			int X = Integer.parseInt(st.nextToken());
			char D = st.nextToken().charAt(0);
			change[i] = new Change(X,D);
		}
		
		Dummy();
		System.out.println(TIME);
	}

	private static void Dummy() { 
		Deque<Loc> Snake = new ArrayDeque<>(); // 뱀을 나타내는 deque
		Snake.offerFirst(new Loc(1,1));
		int cur_dir = 0; // 현재 방향 : 오른쪽
		int idx = 0;
		
		while(true) {
			TIME++;
			Loc loc = Snake.peekFirst();  // 뱀 머리 현재 위치
			
			int nr = loc.r + dr[cur_dir];
			int nc = loc.c + dc[cur_dir];

			if(nr < 1 || nr > N || nc < 1 || nc > N 
					|| board[nr][nc] == 1) break;
			
			if(board[nr][nc] == 2) { // 이동한 칸에 사과가 있다면,
				board[nr][nc] = 1; // 뱀 설정
				Snake.offerFirst(new Loc(nr,nc));
				
			}else {	// 이동한 칸에 사과가 없다면
				Loc tail = Snake.pollLast();
				board[tail.r][tail.c] = 0; // 꼬리가 위치한 칸은 비워준다.
				
				Snake.offerFirst(new Loc(nr,nc));
				board[nr][nc] = 1; // 뱀 설정
			}
			
			/* **************** */ 
			if(idx < L && TIME == change[idx].x) {
				cur_dir = changeDir(cur_dir, change[idx].d);
				idx++;
			}
		}
	}

	private static int changeDir(int cur_dir, char d) {
		if(d == 'D') {
			if(cur_dir == 0) {
				return 2;
			}else if(cur_dir == 1) {
				return 3;
			}else if(cur_dir == 2){
				return 1; 
			}else {
				return 0;
			}
		}else {
			if(cur_dir == 0) {
				return 3;
			}else if(cur_dir == 1) {
				return 2;
			}else if(cur_dir == 2){
				return 0; 
			}else {
				return 1;
			}
		}
	}
}
