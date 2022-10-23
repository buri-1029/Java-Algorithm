package baek.silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.TreeSet;

public class B1251_단어나누기 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		String str = br.readLine();

		TreeSet<String> set = new TreeSet<>();

		for (int i = 1; i < str.length() - 1; i++) {
			for (int j = i + 1; j < str.length(); j++) {
				String tmp1 = sb.append(str, 0, i)
								.reverse()
								.toString();
				sb.setLength(0);

				String tmp2 = sb.append(str, i, j)
								.reverse()
								.toString();
				sb.setLength(0);

				String tmp3 = sb.append(str, j, str.length())
								.reverse()
								.toString();
				sb.setLength(0);

				set.add(tmp1 + tmp2 + tmp3);
			}
		}

		System.out.println(set.first());
	}
}
