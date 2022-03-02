package baek.bronze;

import java.util.Scanner;

public class B2999_비밀이메일 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		String str = sc.next();
		int R = 0, C = 0, idx = 0;

		int N = str.length();
		for (int r = 1; r <= N; r++) {
			for (int c = 1; c <= N; c++) {
				if (r * c == N && r <= c && R < r) {
					R = r;
					C = c;
				}
			}
		}
		char[][] arr = new char[R][C];
		for (int i = 0; i < C; i++) {
			for (int j = 0; j < R; j++) {
				arr[j][i] = str.charAt(idx++);
			}
		}

		for (int i = 0; i < R; i++) {
			for (int j = 0; j < C; j++) {
				System.out.print(arr[i][j]);
			}
		}
	}
}
