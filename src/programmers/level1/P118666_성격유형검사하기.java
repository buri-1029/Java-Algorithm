package programmers.level1;

public class P118666_성격유형검사하기 {

	public static void main(String[] args) {
		String[] survey = {"AN", "CF", "MJ", "RT", "NA"};
		int[] choices = {5, 3, 2, 7, 5};

		System.out.println(solution(survey, choices));

		String[] survey1 = {"TR", "RT", "TR"};
		int[] choices1 = {7, 1, 3};

		System.out.println(solution(survey1, choices1));
	}

	public static String solution(String[] survey, int[] choices) {
		String answer = "";

		int[] score = {0, 3, 2, 1, 0, 1, 2, 3};

		int[] RT = new int[2];
		int[] CF = new int[2];
		int[] JM = new int[2];
		int[] AN = new int[2];

		for (int i = 0; i < choices.length; i++) {
			int choice = choices[i];
			char check = 0;

			if (choice > 4) {
				check = survey[i].charAt(1);
			} else if (choice < 4) {
				check = survey[i].charAt(0);
			}

			int tmp = score[choice];

			switch (check) {
				case 'R' -> RT[0] += tmp;
				case 'T' -> RT[1] += tmp;
				case 'C' -> CF[0] += tmp;
				case 'F' -> CF[1] += tmp;
				case 'J' -> JM[0] += tmp;
				case 'M' -> JM[1] += tmp;
				case 'A' -> AN[0] += tmp;
				case 'N' -> AN[1] += tmp;
			}
		}

		if (RT[0] >= RT[1]) {
			answer += "R";
		} else {
			answer += "T";
		}

		if (CF[0] >= CF[1]) {
			answer += "C";
		} else {
			answer += "F";
		}

		if (JM[0] >= JM[1]) {
			answer += "J";
		} else {
			answer += "M";
		}

		if (AN[0] >= AN[1]) {
			answer += "A";
		} else {
			answer += "N";
		}

		return answer;
	}
}
