package baek.silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// 플로이드 - 와샬
public class B1058_친구 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());

		int[][] dist = new int[51][51];

		for (int i = 1; i <= n; i++) {
			char[] arr = br.readLine()
						   .toCharArray();

			for (int j = 1; j <= n; j++) {
				if (i == j) {
					continue;
				}

				dist[i][j] = arr[j - 1] == 'Y' ? 1 : 100000000;
			}
		}

		for (int k = 1; k <= n; k++) {
			for (int i = 1; i <= n; i++) {
				for (int j = 1; j <= n; j++) {
					if (i == j) {
						continue;
					}

					dist[i][j] = Math.min(dist[i][j], dist[i][k] + dist[k][j]);
				}
			}
		}

		int max = 0;
		for (int i = 1; i <= n; i++) {
			int cnt = 0;

			for (int j = 1; j <= n; j++) {
				if (dist[i][j] == 2 || dist[i][j] == 1) {
					cnt++;
				}
			}

			max = Math.max(max, cnt);
		}

		System.out.println(max);
	}
}
