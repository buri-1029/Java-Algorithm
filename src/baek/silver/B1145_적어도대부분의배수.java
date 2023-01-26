package baek.silver;

import java.util.Scanner;

public class B1145_적어도대부분의배수 {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);

		int[] arr = new int[5];
		for (int i = 0; i < 5; i++) {
			arr[i] = scan.nextInt();
		}

		int cnt = 0;
		int answer = 1;

		while (true) {
			answer++;
			cnt = 0;

			for (int i = 0; i < 5; i++) {
				if (answer % arr[i] == 0) {
					cnt++;
				}
			}

			if (cnt >= 3) {
				break;
			}
		}

		System.out.println(answer);
	}
}
