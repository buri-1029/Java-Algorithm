package baek.silver;

import java.util.Scanner;

public class B3085_사탕게임 {

	public static char[][] board;
	public static int num;
	public static int max = 0;

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		num = scan.nextInt();
		board = new char[num][num];

		String str = "";
		for (int i = 0; i < num; i++) {
			str = scan.next();
			board[i] = str.toCharArray();
		}

		for (int i = 0; i < num; i++) {
			for (int j = 0; j < num - 1; j++) {
				char swap = board[i][j];
				board[i][j] = board[i][j + 1];
				board[i][j + 1] = swap;

				search();

				swap = board[i][j];
				board[i][j] = board[i][j + 1];
				board[i][j + 1] = swap;
			}
		}

		for (int i = 0; i < num; i++) {
			for (int j = 0; j < num - 1; j++) {
				char swap = board[j][i];
				board[j][i] = board[j + 1][i];
				board[j + 1][i] = swap;

				max = Math.max(search(), max);

				swap = board[j][i];
				board[j][i] = board[j + 1][i];
				board[j + 1][i] = swap;
			}
		}

		System.out.println(max);

	}

	private static int search() {
		for (int i = 0; i < num; i++) {
			int cnt = 1;

			for (int j = 0; j < num - 1; j++) {
				if (board[i][j] == board[i][j + 1]) {
					cnt++;
				} else {
					cnt = 1;
				}
				max = Math.max(max, cnt);
			}
		}

		for (int i = 0; i < num; i++) {
			int cnt = 1;

			for (int j = 0; j < num - 1; j++) {
				if (board[j][i] == board[j + 1][i]) {
					cnt++;
				} else {
					cnt = 1;
				}
				max = Math.max(max, cnt);
			}
		}

		return max;
	}
}
