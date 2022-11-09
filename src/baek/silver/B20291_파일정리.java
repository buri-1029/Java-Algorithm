package baek.silver;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Map;
import java.util.TreeMap;

public class B20291_파일정리 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int N = Integer.parseInt(br.readLine());

		Map<String, Integer> map = new TreeMap<>();

		for (int n = 0; n < N; n++) {
			String line = br.readLine();
			for (int i = 0; i < line.length(); i++) {
				if (line.charAt(i) == '.') {
					String key = line.substring(i + 1);
					map.merge(key, 1, Integer::sum);
				}
			}
		}

		for (Map.Entry<String, Integer> entry : map.entrySet()) {
			bw.append(entry.getKey())
			  .append(" ")
			  .append(String.valueOf(entry.getValue()))
			  .append("\n");
		}

		bw.close();
	}
}
