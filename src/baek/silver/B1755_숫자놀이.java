package baek.silver;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class B1755_숫자놀이 {

	public static String[] NUMBER_ENGLISH = {"zero", "one", "two", "three", "four", "five", "six",
		"seven",
		"eight", "nine"};

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int M = sc.nextInt();
		int N = sc.nextInt();

		List<Play> list = new ArrayList<>();

		for (int i = M; i <= N; i++) {
			if (i > 9) {
				list.add(new Play(NUMBER_ENGLISH[i / 10] + " " + NUMBER_ENGLISH[i % 10], i));
			} else {
				list.add(new Play(NUMBER_ENGLISH[i], i));
			}
		}

		Collections.sort(list);

		for (int i = 0; i < list.size(); i++) {
			if (i != 0 && i % 10 == 0) {
				System.out.println();
			}
			System.out.print(list.get(i).number + " ");
		}
	}

	public static class Play implements Comparable<Play> {

		String english;
		int number;

		public Play(String english, int number) {
			this.english = english;
			this.number = number;
		}

		@Override
		public int compareTo(Play o) {
			return this.english.compareTo(o.english);
		}
	}

}
