package baek.silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class B1543_문서검색 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String a = br.readLine();
		String b = br.readLine();
		int answer = 0;

		a = a.replaceAll(b, "!");

		for (char c : a.toCharArray()) {
			if (c == '!') {
				answer++;
			}
		}

		System.out.println(answer);
	}
}
