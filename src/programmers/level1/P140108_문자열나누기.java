package programmers.level1;

public class P140108_문자열나누기 {

	public static void main(String[] args) {
		String s1 = "banana";
		String s2 = "abracadabra";
		String s3 = "aaabbaccccabba";

		System.out.println(solution(s1));
		System.out.println(solution(s2));
		System.out.println(solution(s3));
	}

	public static int solution(String s) {
		int answer = 0;

		int x = 1;
		int y = 0;
		char before = s.charAt(0);

		for (int i = 1; i < s.length(); i++) {
			if (x == y) {
				answer++;

				before = s.charAt(i);
				x = 1;
				y = 0;
			} else if (s.charAt(i) == before) {
				x++;
			} else if (s.charAt(i) != before) {
				y++;
			}
		}

		answer++;

		return answer;
	}
}
