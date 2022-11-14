package baek.silver;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class B25866_배찬우는배열을좋아해 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		String[] input = br.readLine()
						   .split(" ");
		int N = Integer.parseInt(input[0]);
		int M = Integer.parseInt(input[1]);
		int q = Integer.parseInt(input[2]);

		int[][] arr = new int[N][M];

		for (int i = 0; i < N; i++) {
			String[] arrInput = br.readLine()
								  .split(" ");
			for (int j = 0; j < M; j++) {
				arr[i][j] = Integer.parseInt(arrInput[j]);
			}
		}

		for (int i = 0; i < q; i++) {
			String[] calInput = br.readLine()
								  .split(" ");

			int cmd = Integer.parseInt(calInput[0]);
			int a = Integer.parseInt(calInput[1]);
			int b = Integer.parseInt(calInput[2]);

			if (cmd == 0) {
				int k = Integer.parseInt(calInput[3]);
				arr[a][b] = k;
			} else if (cmd == 1) {
				swap(arr, a, b);
			}
		}

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				bw.write(arr[i][j] + " ");
			}
			bw.write("\n");
		}

		bw.flush();
		bw.close();
	}

	private static void swap(int[][] arr, int a, int b) {
		int[] tmp = new int[arr[0].length];

		System.arraycopy(arr[a], 0, tmp, 0, tmp.length);
		System.arraycopy(arr[b], 0, arr[a], 0, tmp.length);
		System.arraycopy(tmp, 0, arr[b], 0, tmp.length);
	}
}
