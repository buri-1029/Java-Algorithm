package programmers.level1;

public class P133499_옹알이2 {

	public static void main(String[] args) {
		String[] babbling1 = {"aya", "yee", "u", "maa"};
		String[] babbling2 = {"ayayeaya", "uuu", "yeye", "yemawoo", "ayaayaa"};

		System.out.println(solution(babbling1));
		System.out.println(solution(babbling2));
	}

	public static int solution(String[] babbling) {
		String[] check = {"aya", "ye", "woo", "ma"};
		int answer = 0;

		for (String s : babbling) {
			String tmp = s;

			tmp = tmp.replace(check[0], "1");
			tmp = tmp.replace(check[1], "2");
			tmp = tmp.replace(check[2], "3");
			tmp = tmp.replace(check[3], "4");

			if (tmp.matches(".*[a-zA-Z].*")) {
			} else if (tmp.contains("11") || tmp.contains("22") || tmp.contains("33")
				|| tmp.contains("44")) {
			} else {
				answer++;
			}
		}

		return answer;
	}

}
