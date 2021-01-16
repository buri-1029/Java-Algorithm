package swexpert;

import java.util.Scanner;

public class S1940_가랏RC카 {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();

		for (int tc = 1; tc <= T; tc++) {
			int speed = 0; // 속도
			int dist = 0; // 이동거리
			int N = sc.nextInt(); // 시간
			for (int i = 0; i < N; i++) {
				int command = sc.nextInt(); // 0 : 현재 속도 그대로 1: 가속 2: 감속
				if (command == 1) {
					int rc = sc.nextInt();
					speed += rc;
					dist += speed;
				} else if (command == 2) {
					int rc = sc.nextInt();
					if (speed < rc)
						speed = 0;
					else
						speed -= rc;
					dist += speed;
				} else {
					dist += speed;
				}
			}
			System.out.println("#" + tc + " " + dist);
		}
	}
}
