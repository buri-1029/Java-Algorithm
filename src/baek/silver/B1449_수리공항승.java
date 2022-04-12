package baek.silver;

import java.util.Arrays;
import java.util.Scanner;

public class B1449_수리공항승 {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int N = scan.nextInt();
		int L = scan.nextInt();
		int[] loc = new int[N];

		for (int i = 0; i < N; i++) {
			loc[i] = scan.nextInt();
		}
		Arrays.sort(loc);

		double before = loc[0] - 0.5;
		int cnt = 1;

		for (int i = 0; i < N; i++) {
			// 테이프를 어느 위치까지 사용할 수 있는 지 확인
			if (before + L < loc[i]) { // 만약 위치가 테이프의 길이를 넘어가면 개수 증가
				cnt++;
				before = loc[i] - 0.5;
			}
		}

		System.out.println(cnt);

	}
}
