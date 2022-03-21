package programmers.courses;

import java.util.Arrays;

public class P96095_문자열내마음대로정렬하기 {

	public static void main(String[] args) {
		String[] strings1 = {"sun", "bed", "car" };
		int n1 = 1;
		System.out.println(Arrays.toString(solution(strings1, n1)));

		String[] strings2 = {"abce", "abcd", "cdx" };
		int n2 = 2;
		System.out.println(Arrays.toString(solution(strings2, n2)));

	}

	public static String[] solution(String[] strings, int n) {
		Arrays.sort(strings, (o1, o2) -> {
			if (o2.charAt(n) == o1.charAt(n)) {
				return o1.compareTo(o2);
			}
			return o1.charAt(n) - o2.charAt(n);
		});

		return strings;
	}
}
