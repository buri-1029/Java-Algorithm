package programmers.Level2;

public class P12951_JadenCase문자열만들기 {

	public static void main(String[] args) {
		String s1 = "3people unFollowed me";
		String s2 = "for the  last week";

		System.out.println(solution(s1));
		System.out.println(solution(s2));
	}

	private static String solution(String s) {
		String answer = "";
		boolean flag = true;

		for (int i = 0; i < s.length(); i++) {
			if (flag && (s.charAt(i) >= 97) && (s.charAt(i) <= 122)) {
				answer += (char) (s.charAt(i) - 32);
				flag = false;
			} else if (!flag && (s.charAt(i) >= 65) && (s.charAt(i) <= 90)) {
				answer += (char) (s.charAt(i) + 32);
			} else if (s.charAt(i) == ' ') {
				answer += s.charAt(i);
				flag = true;
			} else {
				answer += s.charAt(i);
				flag = false;
			}
		}

		return answer;
	}
}
