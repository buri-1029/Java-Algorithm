package baek.silver;

import java.util.Scanner;

public class B2828_사과담기게임 {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int N = scan.nextInt();    // 스크린 칸
		int M = scan.nextInt(); // 바구니사이즈
		int J = scan.nextInt(); // 사과의 개수

		int[] arr = new int[J];
		int cnt = 0;

		for (int i = 0; i < J; i++) {
			arr[i] = scan.nextInt();
		}

		int loc = M;

		for (int i = 0; i < J; i++) {
			while (true) {
				if (arr[i] >= (loc - (M - 1)) && arr[i] <= loc) {
					break;
				} else {
					cnt += 1;

					if (arr[i] > loc) {
						loc += 1;
					} else {
						loc -= 1;
					}
				}
			}
		}

		System.out.println(cnt);
	}
}
