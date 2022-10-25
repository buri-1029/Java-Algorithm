package baek.silver;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class B2210_숫자판점프 {

	public static Set<String> answer;
	public static int[][] arr;
	public static int[] dr = {-1, 1, 0, 0};
	public static int[] dc = {0, 0, -1, 1};

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		answer = new HashSet<>();
		arr = new int[5][5];

		for (int i = 0; i < arr.length; i++) {
			for (int j = 0; j < arr.length; j++) {
				arr[i][j] = sc.nextInt();
			}
		}

		for (int i = 0; i < arr.length; i++) {
			for (int j = 0; j < arr.length; j++) {
				dfs(i, j, arr[i][j] + "");
			}
		}

		System.out.println(answer.size());

	}

	private static void dfs(int r, int c, String num) {

		if (num.length() == 6) {
			answer.add(num);
			return;
		}

		for (int d = 0; d < 4; d++) {
			int nr = r + dr[d];
			int nc = c + dc[d];

			if (nr < 0 || nc < 0 || nr >= arr.length || nc >= arr.length) {
				continue;
			}

			dfs(nr, nc, num + "" + arr[nr][nc]);
		}
	}
}
