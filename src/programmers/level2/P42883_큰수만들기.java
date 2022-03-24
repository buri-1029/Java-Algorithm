package programmers.level2;

public class P42883_큰수만들기 {

	public static void main(String[] args) {
		String number = "1924";
		int k = 2;
		System.out.println(solution(number, k));

		String number1 = "1231234";
		int k1 = 3;
		System.out.println(solution(number1, k1));
	}

	public static String solution(String number, int k) {
		StringBuilder answer = new StringBuilder();
		int idx = 0;
		for (int i = 0; i < number.length() - k; i++) {
			int max = 0;
			for (int j = idx; j <= k + i; j++) {
				if (max < number.charAt(j) - '0') {
					max = number.charAt(j) - '0';
					idx = j + 1;
				}
			}
			answer.append(max);
		}
		return answer.toString();
	}

}
