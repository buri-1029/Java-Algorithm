package programmers.courses;

public class P96087_올바른괄호 {

	public static void main(String[] args) {
		String s1 = "()()";
		String s2 = "(())()";
		String s3 = ")()(";
		String s4 = "(()(";

		System.out.println(solution(s1));
		System.out.println(solution(s2));
		System.out.println(solution(s3));
		System.out.println(solution(s4));
	}

	public static boolean solution(String s) {
		//		Stack<Character> stack = new Stack<>();
		//
		//		for (int i = 0; i < s.length(); i++) {
		//			if (s.charAt(i) == '(') {
		//				stack.push('(');
		//			} else if (s.charAt(i) == ')' && !stack.isEmpty() && stack.peek() == '(') {
		//				stack.pop();
		//			} else {
		//				return false;
		//			}
		//		}
		//		return stack.isEmpty();

		int stack = 0;
		for (char c : s.toCharArray()) {
			if (c == '(') {
				stack++;
			} else {
				if (stack == 0) {
					return false;
				}
				stack--;
			}
		}

		return stack == 0;
	}


}
