package com.algorithm.baek;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class B9205_맥주마시면서걸어가기 {
	static int cur_r, cur_c; // 현재 상근이 위치
	static int rock_r, rock_c; // 락 페스티벌 위치
	static ArrayList<Point> store; // 편의점 위치 저장할 리스트
	static boolean v[];
	static boolean flag;

	static class Point {
		int r, c;

		public Point(int r, int c) {
			super();
			this.r = r;
			this.c = c;
		}
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();

		for (int tc = 0; tc < t; tc++) {
			flag = false;
			store = new ArrayList<>();
			int n = sc.nextInt(); // 편의점 개수
			v = new boolean[n];
			cur_r = sc.nextInt(); // 상근이 집 위치 r
			cur_c = sc.nextInt(); // 상근이 집 위치 c

			for (int i = 0; i < n; i++) {
				store.add(new Point(sc.nextInt(), sc.nextInt()));
			}

			rock_r = sc.nextInt();
			rock_c = sc.nextInt();

			bfs();
			if(flag)
				System.out.println("happy");
			else
				System.out.println("sad");
		}
	}

	private static void bfs() {
		Queue<Point> queue = new LinkedList<>();
		queue.add(new Point(cur_r, cur_c));
		
		while (!queue.isEmpty()) {
			Point cur = queue.poll();

			int dist1 = Math.abs(rock_r - cur.r) + Math.abs(rock_c - cur.c);
			if (dist1 <= 1000) {
				flag = true;
				return;
			}

			for (int i = 0; i < store.size(); i++) {
				int dist2 = Math.abs(store.get(i).r - cur.r) + Math.abs(store.get(i).c - cur.c);
				if (!v[i] && dist2 <= 1000) {
					v[i] = true;
					queue.add(new Point(store.get(i).r, store.get(i).c));
				}
			}

		}
	}
}
