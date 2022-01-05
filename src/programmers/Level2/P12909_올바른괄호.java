package programmers.Level2;

public class P12909_올바른괄호 {

	public static void main(String[] args) {
		String s1 = "()()";
		String s2 = "(())()";
		String s3 = ")()(";
		String s4 = "(()(";
		String s5 = "())()(()";

		System.out.println(solution(s1));
		System.out.println(solution(s2));
		System.out.println(solution(s3));
		System.out.println(solution(s4));
		System.out.println(solution(s5));
	}

	private static boolean solution(String s) {
		boolean answer = false;
		int cnt = 0;

		if (s.charAt(0) == ')') {
			return false;
		}

		for (int i = 0; i < s.length(); i++) {
			if (s.charAt(i) == ')' && cnt == 0) {
				return false;
			} else if (s.charAt(i) == ')') {
				cnt--;
			} else if (s.charAt(i) == '(') {
				cnt++;
			}
		}

		if (cnt == 0) {
			answer = true;
		}

		return answer;
	}

}