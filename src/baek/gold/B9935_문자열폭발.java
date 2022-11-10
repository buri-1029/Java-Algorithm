package baek.gold;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class B9935_문자열폭발 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String before = br.readLine();
		String check = br.readLine();

		// 메모리 초과
		// while (before.contains(check)) {
		// 		before = before.replaceAll(check, "");
		// }

		int tmp1 = before.length();
		int tmp2 = check.length();

		StringBuilder sb = new StringBuilder();

		for (int i = 0; i < tmp1; i++) {
			char c = before.charAt(i);
			sb.append(c);

			if (sb.length() >= tmp2) {
				boolean isSame = true;

				for (int idx = 0; idx < tmp2; idx++) {
					char c1 = sb.charAt(sb.length() - tmp2 + idx);
					char c2 = check.charAt(idx);

					if (c1 != c2) {
						isSame = false;
						break;
					}
				}

				if (isSame) {
					sb.delete(sb.length() - check.length(), sb.length());
				}
			}
		}

		if (sb.length() == 0) {
			System.out.println("FRULA");
		} else {
			System.out.println(sb);
		}
	}

}
