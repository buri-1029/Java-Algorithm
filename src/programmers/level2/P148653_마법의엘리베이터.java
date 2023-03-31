package programmers.level2;

public class P148653_마법의엘리베이터 {

	public static void main(String[] args) {
		System.out.println(solution(678));
		System.out.println(solution(2554));
	}

	public static int solution(int storey) {
		int answer = 0;

		while (storey > 0) {
			int tmp = storey % 10;

			if (tmp >= 6) {
				storey += 10 - tmp;
				answer += 10 - tmp;
			} else if (tmp == 5 && (storey / 10) % 10 >= 5) { // ***
				storey += 10 - tmp;
				answer += 10 - tmp;
			} else {
				answer += tmp;
			}

			storey /= 10;
		}

		return answer;
	}
}
