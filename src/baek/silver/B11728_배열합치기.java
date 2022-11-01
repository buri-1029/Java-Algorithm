package baek.silver;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;

public class B11728_배열합치기 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		String[] input = br.readLine()
						   .split(" ");

		int n = Integer.parseInt(input[0]), m = Integer.parseInt(input[1]);
		int size = n + m;
		int[] result = new int[size];

		String[] arrayA = br.readLine()
							.split(" ");
		String[] arrayB = br.readLine()
							.split(" ");

		int idx = 0;
		for (int i = 0; i < n; i++) {
			result[idx++] = Integer.parseInt(arrayA[i]);
		}

		for (int i = 0; i < m; i++) {
			result[idx++] = Integer.parseInt(arrayB[i]);
		}
		Arrays.sort(result);

		for (int r : result) {
			bw.write(r + " ");
		}

		bw.flush();
		bw.close();
	}
}
