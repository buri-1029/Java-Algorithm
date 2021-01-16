package baek;

import java.util.Scanner;
import java.util.ArrayList;

public class B15686_드래곤커브 {
	static int N, r, c, d, g, er, ec, Ans = 0;
	static boolean[][] map = new boolean[101][101];
	static ArrayList<Integer> dir; 
	static int[] dr = { 0, -1, 0, 1 };
	static int[] dc = { 1, 0, -1, 0 };

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();

		for (int i = 0; i < N; i++) {
			dir = new ArrayList<>();
			c = sc.nextInt();
			r = sc.nextInt();
			d = sc.nextInt();
			g = sc.nextInt();
			map[r][c] = true;
			
			
			r = r + dr[d];
			c = c + dc[d];
			dir.add(d);
			map[r][c] = true;

			for (int j = 1; j <= g; j++) {
				int last = dir.size() - 1;

				for (int k = last; k >= 0; k--) {
					d = (dir.get(k) + 1) % 4;
					r = r + dr[d];
					c = c + dc[d];
					dir.add(d);
					map[r][c] = true;
				}
			}
		}

		for (int i = 0; i < 100; i++) {
			for (int j = 0; j < 100; j++) {
				if (map[i][j] && map[i][j + 1] && map[i + 1][j] && map[i + 1][j + 1]) {
					Ans++;
				}
			}
		}
		System.out.println(Ans);
	}
}
