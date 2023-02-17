package programmers.level1;

public class P159994_카드뭉치 {

	public static void main(String[] args) {
		String[] cards1 = {"i", "drink", "water"};
		String[] cards2 = {"want", "to"};
		String[] goal = {"i", "want", "to", "drink", "water"};
		System.out.println(solution(cards1, cards2, goal));

	}

	public static String solution(String[] cards1, String[] cards2, String[] goal) {
		String answer = "Yes";

		int one = 0;
		int two = 0;

		int i = 0;
		while (i < goal.length) {
			if (one < cards1.length && goal[i].equals(cards1[one])) {
				one++;
			} else if (two < cards2.length && goal[i].equals(cards2[two])) {
				two++;
			} else {
				answer = "No";
				break;
			}

			i++;
		}

		return answer;
	}
}
