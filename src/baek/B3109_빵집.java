package baek;

import java.util.Scanner;

public class B3109_빵집 {
	static int R, C, cnt=0;
	static boolean root;
	static char[][] map;
	static int[] dr = { -1, 0, 1 };
	static int[] dc = { 1, 1, 1 };

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		R = sc.nextInt();
		C = sc.nextInt();
		map = new char[R][C];
		
		for (int r = 0; r < R; r++) {
			String str = sc.next();
			for (int c = 0; c < C; c++) {
				map[r][c] = str.charAt(c);
			}
		}
		for (int r = 0; r < R; r++) {
			root = false; // 파이프 경로 중복되지 않기 위한 조건,
			dfs(r, 0);
		}
		System.out.println(cnt);
	}

	private static void dfs(int r, int c) {
		// TODO Auto-generated method stub
		if(c == C-1) {
			root = true;
			cnt++;
			return;
		}
		for(int k=0;k<3;k++) {
			int nr = r + dr[k];
			int nc = c + dc[k];
			if (nr >= 0 && nr < R && nc >= 0 && nc < C && map[nr][nc] == '.') {
				map[nr][nc] = 'X';
				dfs(nr,nc);
				if(root) return;
			}
		}
	}
}
