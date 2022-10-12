package programmers.level2;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class P131128_숫자짝꿍 {

	public static void main(String[] args) {
		String x1 = "100";
		String y1 = "2345";

		String x2 = "5525";
		String y2 = "1255";

		System.out.println(solution(x1, y1));
		System.out.println(solution(x2, y2));
	}

	public static String solution(String X, String Y) {
		List<String> list = new ArrayList<>();

		String shortStr = X.length() <= Y.length() ? X : Y;
		String longStr = X.length() <= Y.length() ? Y : X;

		for (char c : shortStr.toCharArray()) {
			String tmp = Character.toString(c);

			if (longStr.contains(tmp)) {
				list.add(tmp);
				longStr = longStr.replaceFirst(tmp, "");
			}

		}

		list.sort(Collections.reverseOrder());

		if (list.size() == 0) {
			return "-1";
		}

		String answer = String.join("", list);

		if (answer.charAt(0) == 0) {
			return "0";
		}

		return answer;
	}

}
