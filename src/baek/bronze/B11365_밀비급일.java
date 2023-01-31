package baek.bronze;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class B11365_밀비급일 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		while (true) {
			String str = br.readLine();

			if ("END".equals(str)) {
				break;
			}

			sb.append(new StringBuilder(str).reverse())
			  .append("\n");
		}
		System.out.println(sb);
	}
}
