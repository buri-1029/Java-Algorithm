package programmers.level1;

public class P147355_크기가작은부분문자열 {

	public static void main(String[] args) {
		String t = "10203";
		String p = "15";

		System.out.println(solution(t, p));
	}

	public static int solution(String t, String p) {
		int answer = 0;

		for (int i = 0; i < t.length() - p.length() + 1; i++) {
			long tmp = Long.parseLong((t.substring(i, i + p.length())));
			answer = tmp <= Long.parseLong(p) ? answer + 1 : answer;
		}

		return answer;
	}
}
