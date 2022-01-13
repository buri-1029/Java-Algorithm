package programmers.Level2;

import java.util.Arrays;
import java.util.Comparator;

public class P42746_가장큰수 {

	public static void main(String[] args) {
		int[] numbers = {6, 10, 2};
		int[] numbers2 = {3, 30, 34, 5, 9};

		System.out.println(solution(numbers));
		System.out.println(solution(numbers2));
	}

	private static String solution(int[] numbers) {
		String answer = "";
		String[] strings = new String[numbers.length];

		for (int i = 0; i < strings.length; i++) {
			strings[i] = String.valueOf(numbers[i]);
		}

		Arrays.sort(strings, new Comparator<String>() {
			@Override
			public int compare(String o1, String o2) {
				return ((o2 + o1).compareTo(o1 + o2));
			}
		});

		if ("0".equals(strings[0])) {
			return "0";
		}

		for (String str : strings) {
			answer += str;
		}

		return answer;
	}

}
