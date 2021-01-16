package swexpert;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
/*
 * 먼저 '.'의 8방 주변에 지뢰가 아예 없는 부분부터 선택하기
 * 그 후 남은 '.' 에 대한 클릭 횟수 증가
 *
 */
public class S1868_파핑파핑지뢰찾기 {
	static int N, Ans;
	static char[][] map;
	static boolean[][] visit;
	static int[] dr = {-1, 1, 0, 0, -1, -1, 1, 1};
	static int[] dc = {0, 0, -1, 1, -1, 1, -1, 1};
	static class Point{
		int r, c;

		public Point(int r, int c) {
			super();
			this.r = r;
			this.c = c;
		}
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		
		for(int tc = 1; tc <= T; tc++) {
			N = sc.nextInt();
			map = new char[N][N];
			visit = new boolean[N][N];
			Ans = 0;
			
			for(int i = 0; i < N; i++) {
				String str = sc.next();
				for(int j = 0; j < N; j++) {
					map[i][j] = str.charAt(j);
				}
			}
			
			for(int i = 0; i < N; i++) {
				for(int j = 0; j < N; j++) {
					if(map[i][j] == '.' && !visit[i][j] && check(i,j)) {
						bfs(i,j);
						Ans++;
					}
				}
			}
			
			for(int i = 0; i < N; i++) {
				for(int j = 0; j < N; j++) {
					if(map[i][j] == '.' && !visit[i][j]) {
						Ans++;
					}
				}
			}
			System.out.println("#" + tc + " " + Ans);
		}
	}
	private static boolean check(int r, int c) {
		for (int d = 0; d < 8; d++) {
			int nr = r + dr[d];
			int nc = c + dc[d];

			if (nr < 0 || nc < 0 || nr >= N || nc >= N) continue;
			if (map[nr][nc] == '*') return false;
		}
		return true;
	}
	private static void bfs(int r, int c) {
		Queue<Point> queue = new LinkedList<>();
		queue.add(new Point(r, c));
		visit[r][c] = true;
		
		while(!queue.isEmpty()) {
			Point p = queue.poll();
			
			for(int d = 0; d < 8; d++) {
				int nr = p.r + dr[d];
				int nc = p.c + dc[d];
				
				if(nr < 0 || nc < 0 || nr >= N || nc >= N 
						|| map[nr][nc] == '*' || visit[nr][nc]) continue;
				
				if(check(nr,nc)) queue.add(new Point(nr, nc));
				
				visit[nr][nc] = true;
			}
		}
	}
}
