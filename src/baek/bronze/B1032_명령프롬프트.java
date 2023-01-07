package baek.bronze;

import java.util.Scanner;

public class B1032_명령프롬프트 {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int N = scan.nextInt();

		String[] arr = new String[N];

		for (int i = 0; i < N; i++) {
			arr[i] = scan.next();
		}

		boolean flag;

		for (int i = 0; i < arr[0].length(); i++) {
			flag = false;
			for (int j = 0; j < N - 1; j++) {

				if (arr[j].charAt(i) != arr[j + 1].charAt(i)) {
					flag = true;
					break;
				}

			}

			if (flag) {
				System.out.print("?");
			} else {
				System.out.print(arr[0].charAt(i));
			}

		}

	}
}
