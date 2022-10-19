package baek.silver;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class B11651_좌표정렬하기2 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();

		List<Coordinate> list = new ArrayList<>();

		for (int i = 0; i < N; i++) {
			list.add(new Coordinate(sc.nextInt(), sc.nextInt()));
		}

		Collections.sort(list);

		for (Coordinate c : list) {
			System.out.println(c.x + " " + c.y);
		}
	}

	static class Coordinate implements Comparable<Coordinate> {

		int x;
		int y;

		public Coordinate(int x, int y) {
			this.x = x;
			this.y = y;
		}

		@Override
		public int compareTo(Coordinate o) {
			if (o.y == this.y) {
				return this.x - o.x;
			}
			return this.y - o.y;
		}
	}
}
