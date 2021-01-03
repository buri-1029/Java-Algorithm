package com.algorithm.swexpert;

import java.util.Scanner;

public class S1873_배틀필드 {

	static int H, W, N, idx;
	static int x, y;
	static char state;
	static char[][] map;
	static char[] move;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int T = sc.nextInt();
		for (int tc = 1; tc <= T; tc++) {
			H = sc.nextInt();
			W = sc.nextInt();
			map = new char[H][W];

			for (int i = 0; i < H; i++) {
				idx = 0;
				String str1 = sc.next();
				for (int j = 0; j < W; j++) {
					map[i][j] = str1.charAt(idx++);
					if (map[i][j] == '^' || map[i][j] == 'v' || map[i][j] == '<' || map[i][j] == '>') {
						x = i;
						y = j;
						state = map[i][j];
						map[i][j] = '.';
					}
				}
			}
			N = sc.nextInt();

			String str2 = sc.next();
			for (int i = 0; i < N; i++) {
				switch (str2.charAt(i)) {
				case 'U':
					state = '^';
					if (x - 1 >= 0) {
						if (map[x - 1][y] == '.') {
							x -= 1;
						}
					}
					break;
				case 'D':
					state = 'v';
					if (x + 1 < H) {
						if (map[x + 1][y] == '.') {
							x += 1;
						}
					}
					break;
				case 'L':
					state = '<';
					if (y - 1 >= 0) {
						if (map[x][y - 1] == '.') {
							y -= 1;
						}
					}
					break;
				case 'R':
					state = '>';
					if (y + 1 < W) {
						if (map[x][y + 1] == '.') {
							y += 1;
						}
					}
					break;
				case 'S':
					switch (state) {
					case '^':
						for (int j = x - 1; j >= 0; j--) {/////
							if (map[j][y] == '#') {
								break;
							} else if (map[j][y] == '*') {
								map[j][y] = '.';
								break;
							}
						}
						break;
					case 'v':
						for (int j = x + 1; j < H; j++) {/////
							if (map[j][y] == '#') {
								break;
							} else if (map[j][y] == '*') {
								map[j][y] = '.';
								break;
							}
						}
						break;
					case '<':
						for (int j = y - 1; j >= 0; j--) {
							if (map[x][j] == '#') {
								break;
							} else if (map[x][j] == '*') {
								map[x][j] = '.';
								break;
							}
						}
						break;
					case '>':
						for (int j = y + 1; j < W; j++) {
							if (map[x][j] == '#') {
								break;
							} else if (map[x][j] == '*') {
								map[x][j] = '.';
								break;
							}
						}
						break;
					}
					break;
				}
			}
			map[x][y] = state;
			System.out.print("#"+tc+" ");
			for (int i = 0; i < H; i++) {
				for (int j = 0; j < W; j++) {
					System.out.print(map[i][j]);
				}
				System.out.println();
			}

		}
	}

}
