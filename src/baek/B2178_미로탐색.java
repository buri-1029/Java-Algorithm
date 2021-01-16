package baek;

import java.awt.Point;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

/** 다시 하기 */
public class B2178_미로탐색 {
	static int N, M, cnt = 1;
	static int[][] arr;
	static boolean[][] visited;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		M = sc.nextInt();
		arr = new int[N][M];
		visited = new boolean[N][M];
		
		for (int i = 0; i < N; i++) {
			String str = sc.next();
			for (int j = 0; j < M; j++) {
				arr[i][j] = str.charAt(j) - '0';
			}
		}
		bfs(0, 0);
		System.out.println(arr[N-1][M-1]);
	}

	private static void bfs(int r, int c) {
		// TODO Auto-generated method stub
		Queue<Point> Q = new LinkedList();
		Q.add(new Point(r, c));
		
		
		while (!Q.isEmpty()) {
			Point p = Q.poll();
			visited[r][c] = true;
			
			int[] dr = { 0, 1, -1, 0 };
			int[] dc = { 1, 0, 0, -1 };
			for (int k = 0; k < 4; k++) {
				int nr = p.x + dr[k];
				int nc = p.y + dc[k];
				
				if (nr >= 0 && nr < N && nc >= 0 && nc < M) {
					if(arr[nr][nc] !=0 && !visited[nr][nc]) {
						visited[nr][nc] = true;
						arr[nr][nc] = arr[p.x][p.y]+1;
						Q.add(new Point(nr, nc));
					}
				}
			}
		}
	}
}
