package baek.silver;

import java.util.Scanner;
import java.util.Stack;

public class B4889_안정적인문자열 {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int tc = 1;

		while (true) {
			String str = scan.nextLine();
			if (str.contains("-")) {
				break;
			}

			int n = str.length();
			int cnt = 0;
			Stack<Character> st = new Stack<>();

			for (int i = 0; i < n; i++) {
				char tmp = str.charAt(i);
				if (tmp == '{') {
					st.add(tmp);
				} else {
					if (st.isEmpty()) {
						cnt++;
						st.add('{');
					} else {
						st.pop();
					}
				}
			}

			System.out.println(tc++ + ". " + (cnt + st.size() / 2));
		}
	}
}
