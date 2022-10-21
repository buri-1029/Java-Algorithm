package baek.bronze;

import java.util.Scanner;

public class B1100_하얀칸 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int answer = 0;
		char[][] arr = new char[8][8];

		for (int i = 0; i < arr.length; i++) {
			String str = sc.nextLine();
			for (int j = 0; j < arr.length; j++) {
				arr[i][j] = str.charAt(j);

				if (i % 2 == 0 && j % 2 == 0 && arr[i][j] == 'F') {
					answer++;
				} else if (i % 2 != 0 && j % 2 != 0 && arr[i][j] == 'F') {
					answer++;
				}
			}
		}

		System.out.println(answer);
	}
}
