package baek;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class B14502_연구소 {
	static int N, M, RES = Integer.MIN_VALUE;
	static int[][] lab;
	static boolean[][] visit;
	static Queue<Point> virus = new LinkedList<>();
	static ArrayList<Point> safe = new ArrayList<>();
	static Point[] selected = new Point[3];

	static int[] dr = { -1, 1, 0, 0 };
	static int[] dc = { 0, 0, -1, 1 };

	static class Point {
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
		N = sc.nextInt();
		M = sc.nextInt();
		lab = new int[N][M];

		for (int r = 0; r < N; r++) {
			for (int c = 0; c < M; c++) {
				lab[r][c] = sc.nextInt();
				if (lab[r][c] == 2) {
					virus.add(new Point(r, c));
				} else if (lab[r][c] == 0) {
					safe.add(new Point(r, c));
				}
			}
		}

		make_wall(0, 0);
		System.out.println(RES);
	}

	private static void make_wall(int idx, int cnt) {
		// TODO Auto-generated method stub
		if (cnt == 3) {
			for(int i = 0 ; i < 3 ; i++) {
				lab[selected[i].r][selected[i].c] = 1;
			}
			
			int safe_cnt = virus_bfs(lab);
			RES = Math.max(RES, safe_cnt);
			
			for(int i = 0 ; i < 3 ; i++) {
				lab[selected[i].r][selected[i].c] = 0;
			}
			return;
		}

		if (idx == safe.size()) return;

		for (int i = idx; i < safe.size(); i++) {
			selected[cnt] = safe.get(i);
			make_wall(i + 1, cnt + 1);
		}
	}

	private static int virus_bfs(int[][] tmp) {
		Queue<Point> virus_tmp = new LinkedList<>(virus);
		visit = new boolean[N][M];
		
		for(Point p : virus) {
			visit[p.r][p.c] = true;
		}	
		
		while (!virus_tmp.isEmpty()) {
			Point p = virus_tmp.poll();
				
			for (int d = 0; d < 4; d++) {
				int nr = p.r + dr[d];
				int nc = p.c + dc[d];

				if (nr < 0 || nc < 0 || nr >= N || nc >= M || lab[nr][nc] == 1 || visit[nr][nc]) continue;
				
				virus_tmp.add(new Point(nr, nc));
				visit[nr][nc] = true;
			}
		}
		int cnt = 0;
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if(tmp[i][j] == 0 && !visit[i][j]) {
					cnt++;
				}
			}
		}
		return cnt;
	}
}
