package com.algorithm.baek;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

/** 
 * 총 단지수와 각 단지내 집의 수를 오름차순으로 정렬(BFS, 인접배열 사용)
 * 
 */
public class B2667_단지번호붙이기 {
	static int N; // 아파트 단지 크기
	static int cnt = 0; // 총 아파트 단지 수
	static int count = 0; // 각 단지내 집의 수
	static int[][] arr; // 아파트 단지 배열
	static ArrayList<Integer> adj = new ArrayList(); // 각 단지내 집의 수를 저장할 ArrayList
	static int[] dr = { 1, -1, 0, 0 };
	static int[] dc = { 0, 0, 1, -1 };

	static class Point {
		int r, c;

		Point(int r, int c) {
			this.r = r;
			this.c = c;
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		arr = new int[N][N];

		for (int r = 0; r < N; r++) {
			String input = sc.next();
			for (int c = 0; c < N; c++) {
				arr[r][c] = input.charAt(c) - '0';
			}
		}
		for (int r = 0; r < N; r++) {
			for (int c = 0; c < N; c++) {
				if (arr[r][c] == 1) {
					bfs(r, c);
					adj.add(count);
					count = 0; // 각 단지내 집의 수 다시 초기화
					cnt++; // 아파트 단지 수 증가
				}
			}
		}
		Collections.sort(adj); // 오름차순으로 정렬
		System.out.println(cnt);
		for (int i = 0; i < adj.size(); i++) {
			System.out.println(adj.get(i));
		}
	}

	private static void bfs(int r, int c) {
		// TODO Auto-generated method stub
		Queue<Point> Q = new LinkedList();
		Q.add(new Point(r, c));
		arr[r][c] = 0; // 방문한 집은 0으로 표시

		while (!Q.isEmpty()) {
			Point p = Q.poll();
			count += 1; // 각 단지내 집의 수 증가

			// 상하좌우 인접한 집(1)이 있는지 확인
			for (int k = 0; k < 4; k++) {
				int nr = p.r + dr[k];
				int nc = p.c + dc[k];
				if (nr >= 0 && nr < N && nc >= 0 && nc < N && arr[nr][nc] == 1) {
					arr[nr][nc] = 0; // 방문한 집은 0으로 표시
					Q.add(new Point(nr, nc));
				}
			}
		}
	}
}
