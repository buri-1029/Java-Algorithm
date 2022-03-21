package programmers.courses;

public class P96096_JadenCase문자열만들기 {

	public static void main(String[] args) {
		String s1 = "3people unFollowed me";
		String s2 = "for the last week";
		String s3 = "a a a a a a a a a a ";

		System.out.println(solution(s1));
		System.out.println(solution(s2));
		System.out.println(solution(s3));
	}

	public static String solution(String s) {
		StringBuilder answer = new StringBuilder();
		String str = s.toLowerCase();
		char last = ' ';

		for (char c : str.toCharArray()) {
			if (last == ' ') {
				c = Character.toUpperCase(c);
			}
			answer.append(c);
			last = c;
		}

		return answer.toString();
	}
}
