package baek.silver;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class B2822_점수계산 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		List<Score> list = new ArrayList<>();

		for (int i = 0; i < 8; i++) {
			list.add(new Score(i + 1, sc.nextInt()));
		}

		Collections.sort(list);

		int[] answer = new int[5];
		int idx = 0;
		int sum = 0;

		for (int i = 3; i < list.size(); i++) {
			answer[idx++] = list.get(i).order;
			sum += list.get(i).score;
		}

		Arrays.sort(answer);

		System.out.println(sum);

		for (int n : answer) {
			System.out.print(n + " ");
		}

	}

	static class Score implements Comparable<Score> {

		int order;
		int score;

		public Score(int order, int score) {
			this.order = order;
			this.score = score;
		}

		@Override
		public int compareTo(Score o) {
			return this.score - o.score;
		}
	}

}
