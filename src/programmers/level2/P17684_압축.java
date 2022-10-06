package programmers.level2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class P17684_압축 {

	public static void main(String[] args) {
		String msg1 = "KAKAO";
		String msg2 = "TOBEORNOTTOBEORTOBEORNOT";
		String msg3 = "ABABABABABABABAB";

		System.out.println(Arrays.toString(solution(msg1)));
		System.out.println(Arrays.toString(solution(msg2)));
		System.out.println(Arrays.toString(solution(msg3)));
	}

	public static int[] solution(String msg) {
		String[] alphabet = {"A", "B", "C", "D", "E", "F", "G", "H", "I", "J", "K", "L", "M",
			"N", "O", "P", "Q", "R", "S", "T", "U", "V", "W", "X", "Y", "Z"};

		List<Integer> answer = new ArrayList<>();
		List<String> word = new ArrayList<>(Arrays.asList(alphabet));

		int cur = 0, next = 2;
		boolean end = false;

		while (true) {

			if (cur == msg.length() - 1) {
				String w = msg.substring(cur);
				answer.add(word.indexOf(w) + 1);
				break;
			}

			while (word.contains(msg.substring(cur, cur + next))) {
				if (cur + next >= msg.length()) {
					end = true;
					break;
				}
				next++;
			}

			if (end) {
				String w = msg.substring(cur);
				answer.add(word.indexOf(w) + 1);
				break;
			}

			String w = msg.substring(cur, cur + next - 1);
			String wc = msg.substring(cur, cur + next);

			word.add(wc);
			answer.add(word.indexOf(w) + 1);

			cur += next > 2 ? (next - 2 + 1) : 1;
			next = 2;
		}

		return answer.stream()
					 .mapToInt(Integer::intValue)
					 .toArray();
	}
}
