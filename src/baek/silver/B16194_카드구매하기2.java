package baek.silver;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

/* 솔루션 참고 */
public class B16194_카드구매하기2 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int N = Integer.parseInt(br.readLine());
		int[] P = new int[N + 1];

		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 1; i <= N; i++) {
			P[i] = Integer.parseInt(st.nextToken());

			for (int j = 1; j < i; j++) {
				P[i] = Math.min(P[i], P[j] + P[i - j]);
			}
		}
		bw.write(P[N] + "\n");

		bw.flush();
		br.close();
		bw.close();
	}
}
