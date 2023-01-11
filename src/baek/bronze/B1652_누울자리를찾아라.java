package baek.bronze;

import java.util.Scanner;

public class B1652_누울자리를찾아라 {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int N = scan.nextInt();

		char[][] arr = new char[N][N];

		for (int i = 0; i < N; i++) {
			String str = scan.next();
			for (int j = 0; j < N; j++) {
				arr[i][j] = str.charAt(j);
			}
		}

		int answer1 = 0;
		int answer2 = 0;

		for (int i = 0; i < N; i++) {
			int a = 0, b = 0;
			for (int j = 0; j < N; j++) {
				if (arr[i][j] == '.') {
					a++;
				}

				if (arr[i][j] == 'X' || j == N - 1) {
					if (a >= 2) {
						answer1++;
					}
					a = 0;
				}

				if (arr[j][i] == '.') {
					b++;
				}

				if (arr[j][i] == 'X' || j == N - 1) {
					if (b >= 2) {
						answer2++;
					}
					b = 0;
				}
			}
		}

		System.out.println(answer1 + " " + answer2);

	}
}
