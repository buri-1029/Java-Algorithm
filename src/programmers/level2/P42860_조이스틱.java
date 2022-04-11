package programmers.level2;

public class P42860_조이스틱 {

	public static void main(String[] args) {
		String name1 = "JEROEN";
		String name2 = "JAN";

		System.out.println(solution(name1));
		System.out.println(solution(name2));
	}

	public static int solution(String name) {
		int answer = 0;
		int len = name.length();

		int idx;
		int move = len - 1;

		for (int i = 0; i < name.length(); i++) {
			answer += Math.min(name.charAt(i) - 'A', 'Z' - name.charAt(i) + 1);
			idx = i + 1;

			while (idx < len && name.charAt(idx) == 'A') {
				idx++;
			}

			move = Math.min(Math.min(move, i * 2 + len - idx), (len - idx) * 2 + i);
		}

		return answer + move;
	}
}
