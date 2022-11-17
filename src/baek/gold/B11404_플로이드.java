package baek.gold;

import java.util.Scanner;

public class B11404_플로이드 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int m = sc.nextInt();

		int[][] dist = new int[n][n];

		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				if (i == j) {
					dist[i][j] = 0;
				} else {
					dist[i][j] = 1000000000;
				}
			}
		}

		for (int i = 0; i < m; i++) {
			int a = sc.nextInt() - 1;
			int b = sc.nextInt() - 1;
			int c = sc.nextInt();

			dist[a][b] = Math.min(dist[a][b] == 0 ? c : dist[a][b], c);
		}

		for (int k = 0; k < n; k++) {
			for (int i = 0; i < n; i++) {
				for (int j = 0; j < n; j++) {
					dist[i][j] = Math.min(dist[i][j], dist[i][k] + dist[k][j]);

				}
			}
		}

		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				if (dist[i][j] >= 1000000000) {
					sb.append("0 ");
				} else {
					sb.append(dist[i][j])
					  .append(" ");
				}
			}
			sb.append("\n");
		}
		System.out.println(sb);
	}
}
