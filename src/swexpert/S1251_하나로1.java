package swexpert;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class S1251_하나로1 {
	static int N; 			// 섬의 개수
	static double E;		// 환경 부담 세율 실수
	static Point[] island;	// 섬 좌표 저장할 공간
	static int[] parents;	

	static class Point implements Comparable<Point> {
		int x, y;
		double w;

		public Point(int x, int y, double w) {
			this.x = x;
			this.y = y;
			this.w = w;
		}

		// weight 기준으로 sort
		public int compareTo(Point p) {
			// TODO Auto-generated method stub
			if (this.w < p.w) { 
				return -1;
			} else if (this.w > p.w) {
				return 1;
			}
			return 0;
		}

		@Override
		public String toString() {
			return "Point [x=" + x + ", y=" + y + ", w=" + w + "]";
		}
		
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();

		for (int tc = 1; tc <= T; tc++) {
			N = sc.nextInt();
			island = new Point[N];
			double ANS = 0.0; // 테케마다 초기화

			for (int i = 0; i < N; i++) {
				// 처음 입력할 때 Point 객체 생성하면서 
				island[i] = new Point(sc.nextInt(), 0, 0); 
			}

			for (int i = 0; i < N; i++) {
				island[i].y = sc.nextInt(); 
			}
			E = sc.nextDouble();

			// 간선리스트 -> 모든 좌표들 거리(가중치)
			ArrayList<Point> weights = new ArrayList<>();
			parents = new int[N];
			
			/** ***** */
			for (int i = 0; i < N - 1; i++) {
				for (int j = i + 1; j < N; j++) {
					// 환경 부담 세율(E)과 각 해저터널 길이(L)의 제곱의 곱(E * L^2)만큼 지불
					double L = Math.sqrt(Math.pow(island[i].x - island[j].x, 2)
							+ Math.pow(island[i].y - island[j].y, 2));
					double w = (E * Math.pow(L, 2));
					
					// 리스트에 저장 (섬 배열의 i인덱스가 x좌표 , j인덱스가 y좌표라, w)
					weights.add(new Point(i, j, w));
				}
			}

			Collections.sort(weights);

			// makeSet
			for (int i = 0; i < N; i++) {
				parents[i] = i;
			}

			for (int i = 0; i < weights.size(); i++) {
				Point ww = weights.get(i);
				if (find(ww.x) != find(ww.y)) {
					ANS += ww.w;
					union(ww.x, ww.y);
				}
			}
			System.out.printf("#%d %.0f\n",tc, ANS);
		}
	}

	private static void union(int x, int y) {
		int px = find(x);
		int py = find(y);
		if (px >= py)
			parents[px] = py;
		else
			parents[py] = px;
	}

	private static int find(int x) {
		if (parents[x] == x) {
			return parents[x];
		} else {
			return find(parents[x]);
		}
	}
}
