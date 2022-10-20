package baek.silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class B18860_좌표압축 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int N = Integer.parseInt(br.readLine());

		int[] arr = new int[N];
		int[] sorted = new int[N];
		Map<Integer, Integer> map = new HashMap<>();

		StringTokenizer st = new StringTokenizer(br.readLine(), " ");

		for (int i = 0; i < N; i++) {
			arr[i] = sorted[i] = Integer.parseInt(st.nextToken());
		}

		Arrays.sort(sorted);

		int tmp = 0;
		for (int n : sorted) {
			if (!map.containsKey(n)) {
				map.put(n, tmp);
				tmp++;
			}
		}

		StringBuilder sb = new StringBuilder();
		for (int n : arr) {
			sb.append(map.get(n))
			  .append(' ');
		}

		System.out.println(sb);

	}
}
