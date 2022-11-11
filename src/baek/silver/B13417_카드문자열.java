package baek.silver;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

public class B13417_카드문자열 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int T = Integer.parseInt(br.readLine());

		for (int t = 0; t < T; t++) {
			int N = Integer.parseInt(br.readLine());
			StringTokenizer st = new StringTokenizer(br.readLine());

			Deque<String> deque = new ArrayDeque<>();
			deque.addFirst(st.nextToken());

			for (int i = 1; i < N; i++) {
				String s = st.nextToken();

				if (deque.getFirst()
						 .compareTo(s) < 0) {
					deque.addLast(s);
				} else {
					deque.addFirst(s);
				}
			}

			for (String str : deque) {
				bw.write(str);
			}

			bw.write("\n");
		}

		br.close();
		bw.close();
	}

}
