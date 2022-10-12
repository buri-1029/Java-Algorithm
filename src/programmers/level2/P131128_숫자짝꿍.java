package programmers.level2;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/*
	X, Y 중 하나를 기준을 잡는 방법이 아니라
	숫자 0 ~ 9를 이용하는 방법으로 변경,,,
 */
public class P131128_숫자짝꿍 {

	public static void main(String[] args) {
		String x1 = "100";
		String y1 = "203045";

		String x2 = "5525";
		String y2 = "1255";

		System.out.println(solution(x1, y1));
		System.out.println(solution(x2, y2));

	}

	public static String solution(String X, String Y) {
		List<String> list = new ArrayList<>();

		for (int i = 0; i <= 9; i++) {
			String tmp = String.valueOf(i);

			if (X.contains(tmp) && Y.contains(tmp)) {

				int x = countChar(X, tmp);
				int y = countChar(Y, tmp);

				int min = Math.min(x, y);

				for (int j = 0; j < min; j++) {
					list.add(tmp);
				}
			}
		}

		list.sort(Collections.reverseOrder());

		if (list.size() == 0) {
			return "-1";
		}

		String answer = String.join("", list);

		if (answer.charAt(0) == '0') {
			return "0";
		}

		return answer;
	}

	public static int countChar(String str, String s) {
		return str.length() - str.replace(s, "")
								 .length();
	}


}
