package baek;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class B2538_영역구하기 {
	static int M, N, K, cnt = 0, area;
	static int[][] arr;
	static int[] dr = { 1, -1, 0, 0 };
	static int[] dc = { 0, 0, 1, -1 };

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		M = sc.nextInt();
		N = sc.nextInt();
		K = sc.nextInt();

		arr = new int[M][N];

		for (int k = 0; k < K; k++) {
			int x1 = sc.nextInt();
			int y1 = sc.nextInt();
			int x2 = sc.nextInt();
			int y2 = sc.nextInt();

			for (int r = y1; r < y2; r++) {
				for (int c = x1; c < x2; c++) {
					arr[r][c] = 1;
				}
			}
		}
		ArrayList<Integer> list = new ArrayList<>();

		for (int r = 0; r < M; r++) {
			for (int c = 0; c < N; c++) {
				if (arr[r][c] == 0) {
					dfs(r, c);
					cnt++;
					list.add(area);
					area = 0;
				}
			}
		}
		System.out.println(cnt);
		
		
		Collections.sort(list);
		
		for (int i : list) {
			System.out.print(i + " ");
		}

	}

	private static void dfs(int r, int c) {
		// TODO Auto-generated method stub
		arr[r][c] = 1; // 방문한 좌표 1로 표시
		area++; // 각각 분리된 영역

		for (int i = 0; i < 4; i++) {
			int nr = r + dr[i];
			int nc = c + dc[i];

			if (nr >= 0 && nr < M && nc >= 0 && nc < N && arr[nr][nc] == 0) {
				dfs(nr, nc);
			}
		}
	}

}
