package baek.silver;

import java.util.Scanner;

public class B11060_점프점프 {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int N = scan.nextInt();
		int[] arr = new int[N];

		for (int i = 0; i < N; i++) {
			arr[i] = scan.nextInt();
		}

		int idx = 1;
		int cnt = 0;
		boolean flag = false;

		while (idx < N) {
			int max = 0;
			int maxIdx = 0;

			for (int i = idx + 1; i <= idx + arr[idx]; i++) {
				if (i >= N) {
					flag = true;
					break;
				}

				if (max < i + arr[i]) {
					max = i + arr[i];
					maxIdx = i;
				}
			}

			if (arr[idx] == 0) {
				cnt = -1;
				break;
			}

			cnt++;
			idx = maxIdx;

			if (flag) {
				break;
			}
		}

		System.out.println(cnt);
	}

}
