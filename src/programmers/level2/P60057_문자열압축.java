package programmers.level2;

public class P60057_문자열압축 {

	public static void main(String[] args) {
		String s1 = "aabbaccc";
		System.out.println(solution(s1));

		String s2 = "ababcdcdababcdcd";
		System.out.println(solution(s2));

		String s3 = "abcabcdede";
		System.out.println(solution(s3));

		String s4 = "abcabcabcabcdededededede";
		System.out.println(solution(s4));

		String s5 = "xababcdcdababcdcd";
		System.out.println(solution(s5));

	}

	public static int solution(String s) {
		int answer = s.length();

		for (int i = 1; i <= s.length() / 2; i++) {
			StringBuilder tmp = new StringBuilder();
			String before = s.substring(0, i);
			int cnt = 1;

			for (int j = i; j < s.length(); j += i) {
				String cur = j + i < s.length() ? s.substring(j, j + i) : s.substring(j);

				if (before.equals(cur)) {
					cnt++;
				} else {
					if (cnt == 1) {
						tmp.append(before);
					} else {
						tmp.append(cnt)
						   .append(before);
					}

					before = cur;
					cnt = 1;
				}
			}

			if (cnt == 1) {
				tmp.append(before);
			} else {
				tmp.append(cnt)
				   .append(before);
			}

			answer = Math.min(answer, tmp.length());
		}

		return answer;
	}
}
