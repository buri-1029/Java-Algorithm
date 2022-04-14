package baek.silver;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class B1947_신입사원 {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int T = scan.nextInt();

		for (int t = 0; t < T; t++) {
			int N = scan.nextInt();
			List<Rank> list = new ArrayList<>();

			for (int i = 0; i < N; i++) {
				list.add(new Rank(scan.nextInt(), scan.nextInt()));
			}
			Collections.sort(list);

			int answer = 1;
			int min = list.get(0).b;

			for (int i = 1; i < N; i++) {
				if (list.get(i).b < min) {
					answer++;
					min = list.get(i).b;
				}
			}

			System.out.println(answer);
		}
	}

	static class Rank implements Comparable<Rank> {

		int a, b;

		public Rank(int a, int b) {
			this.a = a;
			this.b = b;
		}

		@Override
		public int compareTo(Rank rank) {
			return this.a - rank.a;
		}
	}
}
