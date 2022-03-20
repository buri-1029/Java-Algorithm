package programmers.courses;

public class P96092_문자열내p와y의개수 {

	public static void main(String[] args) {
		String s1 = "pPoooyY";
		String s2 = "Pyy";

		System.out.println(solution(s1));
		System.out.println(solution(s2));
	}

	public static boolean solution(String s) {
		//		int p = 0, y = 0;
		//		String lowerCase = s.toLowerCase();
		//
		//		for (char lower : lowerCase.toCharArray()) {
		//			if (lower == 'p') {
		//				p++;
		//			} else if (lower == 'y') {
		//				y++;
		//			}
		//		}

		int p = s.replaceAll("[^pP]", "")
				 .length();
		int y = s.replaceAll("[^yY]", "")
				 .length();
		return p == y;
	}
}
