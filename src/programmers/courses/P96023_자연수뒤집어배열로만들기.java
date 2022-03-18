package programmers.courses;

import java.util.Arrays;

public class P96023_자연수뒤집어배열로만들기 {

	public static void main(String[] args) {
		long n = 12345;
		System.out.println(Arrays.toString(solution(n)));

	}

	public static int[] solution(long n) {
		String strNum = Long.toString(n);
		int len = strNum.length();
		int[] answer = new int[len];

		int idx = 0;
		while (n != 0) {
			answer[idx++] = (int) (n % 10);
			n /= 10;
		}

		return answer;
	}
}
