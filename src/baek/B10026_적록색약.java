package baek;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

/** bfs 한번 사용하는 것으로 다시 풀기 */
public class B10026_적록색약 {
	static int N, cnt1 = 0, cnt2 = 0;
	static char[][] arr1; // 아닌사람
	static int[][] arr2; // 적록색약인
	static char[] RGB = { 'R', 'G', 'B' };
	static int[] dr = { 1, -1, 0, 0 }; // 4방으로 상하좌우 검색
	static int[] dc = { 0, 0, 1, -1 }; 

	static class Point {
		int r, c;

		public Point(int r, int c) {
			this.r = r;
			this.c = c;
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		arr1 = new char[N][N];
		arr2 = new int[N][N];

		for (int i = 0; i < N; i++) {
			String str = sc.next();
			for (int j = 0; j < N; j++) {
				arr1[i][j] = str.charAt(j); // 입력받은 값 배열 저장

				if (arr1[i][j] == 'B') // 파랑인 경우에는
					arr2[i][j] = 1; // arr2 배열에 1로 저장, 나머지(초록, 빨강)는 0
			}
		}
		// 적록색약인이 아닌경우 R,G,B 가 저장되어 있는 arr1 배열로 bfs 검색
		for (int i = 0; i <= 2; i++) { // 총 3번
			for (int r = 0; r < N; r++) {
				for (int c = 0; c < N; c++) {
					if (arr1[r][c] == RGB[i]) { // R, G, B 인 경우 검색하기
						bfs1(r, c, RGB[i]);
						cnt1++;
					}
				}
			}
		}
		// 적록색약인 경우 0, 1 이 저장되어 있는 arr2 배열로 bfs 검색
		for (int i = 0; i <= 1; i++) { // 총 2번
			for (int r = 0; r < N; r++) {
				for (int c = 0; c < N; c++) {
					if (arr2[r][c] == i) { // 0, 1인 경우 검색하기
						bfs2(r, c, i);
						cnt2++;
					}
				}
			}
		}

		System.out.println(cnt1 + " " + cnt2);
	}

	private static void bfs1(int r, int c, char x) {
		// TODO Auto-generated method stub
		Queue<Point> Q = new LinkedList<>();
		Q.add(new Point(r, c));
		arr1[r][c] = 'X';

		while (!Q.isEmpty()) {
			Point p = Q.poll();
			for (int k = 0; k < 4; k++) {
				int nr = p.r + dr[k];
				int nc = p.c + dc[k];
				if (nr >= 0 && nr < N && nc >= 0 && nc < N && arr1[nr][nc] == x) {
					arr1[nr][nc] = 'X';
					Q.add(new Point(nr, nc));
				}
			}
		}
	}

	private static void bfs2(int r, int c, int i) {
		// TODO Auto-generated method stub
		Queue<Point> Q = new LinkedList<>();
		Q.add(new Point(r, c));
		arr2[r][c] = -1;

		while (!Q.isEmpty()) {
			Point p = Q.poll();
			for (int k = 0; k < 4; k++) {
				int nr = p.r + dr[k];
				int nc = p.c + dc[k];
				if (nr >= 0 && nr < N && nc >= 0 && nc < N && arr2[nr][nc] == i) {
					arr2[nr][nc] = -1;
					Q.add(new Point(nr, nc));
				}
			}
		}
	}
}
