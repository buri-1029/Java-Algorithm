package programmers.level2;

import java.util.Arrays;

public class P70129_이진변환반복하기 {

	public static void main(String[] args) {
		String s1 = "110010101001";
		String s2 = "01110";
		String s3 = "1111111";

		System.out.println(Arrays.toString(solution(s1)));
		System.out.println(Arrays.toString(solution(s2)));
		System.out.println(Arrays.toString(solution(s3)));
	}

	public static int[] solution(String s) {
		int[] answer = new int[2];

		while (!s.equals("1")) {
			answer[1] += s.length() - s.replace("0", "")
									   .length();

			s = s.replaceAll("0", "");

			s = Integer.toBinaryString(s.length());

			answer[0]++;
		}

		return answer;
	}

}
