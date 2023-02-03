package programmers.level1;

public class P155652_둘만의암호 {

	public static void main(String[] args) {
		String s = "ybcde";
		String skip = "az";
		int index = 1;

		System.out.println(solution(s, skip, index));
	}

	public static String solution(String s, String skip, int index) {
		String answer = "";

		for (int i = 0; i < s.length(); i++) {
			char cur = s.charAt(i);
			int cnt = 0;

			while (cnt < index) {
				if (cur + 1 > 122) {
					cur = '`';
				}

				if (!skip.contains(String.valueOf((char) (cur + 1)))) {
					cnt++;
				}

				cur = (char) (cur + 1);
			}

			answer += cur;
		}

		return answer;
	}
}
