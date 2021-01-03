package com.algorithm.baek;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/*
 *  다시 풀어보기
 */
public class B1600_말이되고픈원숭이 {
	static int K, W, H, RES = -1;
	static int[][] board;
	static int[][][] dist;
	static int[] dr = { -1, 0, 1, 0 }; // 그냥 인접한 칸으로 이동
	static int[] dc = { 0, 1, 0, -1 };
	static int[] hr = { -1, -2, -1, -2, 1, 2, 1, 2 }; // 말처럼 이동
	static int[] hc = { -2, -1, 2, 1, -2, -1, 2, 1 };

	static class Monkey {
		int r, c, k, cnt;

		public Monkey(int r, int c, int k, int cnt) {
			super();
			this.r = r;
			this.c = c;
			this.k = k;
			this.cnt = cnt;
		}
	}

	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		K = Integer.parseInt(br.readLine()); // 말처럼 이동할 수 있는 K번
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		W = Integer.parseInt(st.nextToken()); // 가로길이
		H = Integer.parseInt(st.nextToken()); // 세로길이
		
		board = new int[H][W];	// 격자판
		dist = new int[H][W][K + 1]; // 원숭이가 이동한 횟수 저장하는 3차원 배열

		for (int i = 0; i < H; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for (int j = 0; j < W; j++) {
				board[i][j] = Integer.parseInt(st.nextToken());
			}
		}// 입력 받기

		bfs(); // 원숭이 이동하기
		System.out.println(RES);
	}

	private static void bfs() {
		// TODO Auto-generated method stub
		Queue<Monkey> queue = new LinkedList<>();
		queue.add(new Monkey(0, 0, 0, 0));
		dist[0][0][0] = 0;

		while (!queue.isEmpty()) {
			Monkey m = queue.poll();

			if (m.r == H - 1 && m.c == W - 1) { // 도착점에 도착했으면 
				RES = dist[m.r][m.c][m.k];		// 결과값에 dist 배열에 있는 이동 횟수 저장
				break;
			}

			if (m.k < K) { // 현재 위치에서 k값이 입력받은 K보다 작으면
				for (int h = 0; h < 8; h++) { // 말처럼 이동 가능
					int nr = m.r + hr[h];
					int nc = m.c + hc[h];
					if (nr >= 0 && nr < H && nc >= 0 && nc < W && board[nr][nc] != 1 && dist[nr][nc][m.k + 1] == 0) {
						dist[nr][nc][m.k + 1] = m.cnt + 1;
						queue.add(new Monkey(nr, nc, m.k + 1, m.cnt + 1));
					}
				}
			}
			// 아예 일반으로만 이동 했을 경우도 있으니깐 else로 안 나눔
			for (int d = 0; d < 4; d++) { 
				int nr = m.r + dr[d];
				int nc = m.c + dc[d];
				if (nr >= 0 && nr < H && nc >= 0 && nc < W && board[nr][nc] != 1 && dist[nr][nc][m.k] == 0) {
					dist[nr][nc][m.k] = m.cnt + 1;
					queue.add(new Monkey(nr, nc, m.k, m.cnt + 1));
				}
			}			
		}
	}
}
