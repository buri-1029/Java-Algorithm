package baek.bronze;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class B9093_단어뒤집기 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		StringBuilder answer = new StringBuilder();

		for (int i = 0; i < T; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());

			while (st.hasMoreTokens()) {
				StringBuilder sb = new StringBuilder(st.nextToken());
				answer.append(sb.reverse())
					  .append(" ");
			}

			answer.append("\n");
		}

		System.out.print(answer);
	}
}
