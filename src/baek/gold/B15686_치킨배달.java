package baek.gold;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * 폐업시키지 않을 치킨집을 최대 M개를 골랐을 때, 도시의 치킨 거리의 최솟값 → 집들과 가장 가까운 치킨집과의 거리들 총합 중 최솟값
 */
public class B15686_치킨배달 {

	static int N, M, res = Integer.MAX_VALUE;
	static ArrayList<Point> home;
	static ArrayList<Point> chicken;
	static Point[] select;

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		M = sc.nextInt();

		home = new ArrayList<>();
		chicken = new ArrayList<>();
		select = new Point[M];

		for (int r = 1; r <= N; r++) {
			for (int c = 1; c <= N; c++) {
				int num = sc.nextInt();

				if (num == 1) {
					home.add(new Point(r, c));
				} else if (num == 2) {
					chicken.add(new Point(r, c));
				}
			}
		}
		combination(0, 0);
		System.out.println(res);
	}

	private static void combination(int idx, int k) {
		// TODO Auto-generated method stub
		if (k == M) {
			//System.out.println(Arrays.toString(select));
			min_dist(select);
			return;
		}
		if (idx == chicken.size()) {
			return;
		}

		select[k] = chicken.get(idx);
		combination(idx + 1, k + 1);
		combination(idx + 1, k);

	}

	private static void min_dist(Point[] select) {
		// TODO Auto-generated method stub
		int total = 0;

		for (Point h : home) {
			int min = Integer.MAX_VALUE;
			for (Point c : select) {
				int dist = Math.abs(h.r - c.r) + Math.abs(h.c - c.c);
				min = Math.min(min, dist); // 집과 가장 가까운 치킨집과의 거리 (최소)
			}
			total += min; // 그 거리들의 총 합
		}
		res = Math.min(total, res); // 그 거리들의 총 합 중 가장 작은 값
	}

	static class Point {

		int r, c;

		public Point(int r, int c) {
			super();
			this.r = r;
			this.c = c;
		}
	}
}
