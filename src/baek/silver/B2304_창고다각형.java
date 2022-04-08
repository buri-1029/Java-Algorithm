package baek.silver;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class B2304_창고다각형 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int area = 0;

		ArrayList<Info> arr = new ArrayList<>();
		for (int i = 0; i < N; i++) {
			arr.add(new Info(sc.nextInt(), sc.nextInt()));
		}
		Collections.sort(arr);

		int max = 0;

		Info before = arr.get(0);
		for (int i = 1; i < arr.size(); i++) {
			if (before.h <= arr.get(i).h) {
				area += (arr.get(i).l - before.l) * before.h;
				before = arr.get(i);
				max = i;
			}
		}

		before = arr.get(N - 1);
		for (int i = 0; i < N - max; i++) {
			if (before.h <= arr.get(N - i - 1).h) {
				area += (before.l - arr.get(N - i - 1).l) * before.h;
				before = arr.get(N - i - 1);
			}
		}

		area += before.h;
		System.out.println(area);
	}

	static class Info implements Comparable<Info> {

		int l, h;

		Info(int l, int h) {
			this.l = l;
			this.h = h;
		}

		@Override
		public int compareTo(Info o) {
			return this.l - o.l;
		}
	}
}
