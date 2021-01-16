package baek;

import java.util.ArrayList;
import java.util.Scanner;

public class B2628_종이자르기 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int M = sc.nextInt();
		int N = sc.nextInt();

		int[][] map = new int[N][M];

		int K = sc.nextInt();
		ArrayList<Integer> row = new ArrayList<>();
		ArrayList<Integer> col = new ArrayList<>();

		for (int k = 0; k < K; k++) {
			int num1 = sc.nextInt();
			int num2 = sc.nextInt();

			if (num1 == 0) {
				row.add(num2);
			} else {
				col.add(num2);
			}
		}
		row.add(N);
		col.add(M);

		row.sort(null);
		col.sort(null);

		ArrayList<Integer> row_length = new ArrayList<>();
		ArrayList<Integer> col_length = new ArrayList<>();

		for (int i = 0; i < row.size(); i++) {
			if (i == 0) {
				row_length.add(row.get(i));
			} else {
				row_length.add(row.get(i) - row.get(i - 1));
			}
		}

		for (int i = 0; i < col.size(); i++) {
			if (i == 0) {
				col_length.add(col.get(i));
			} else {
				col_length.add(col.get(i) - col.get(i - 1));
			}
		}

		row_length.sort(null);
		col_length.sort(null);

		int n1 = row_length.get(row_length.size() - 1);
		int n2 = col_length.get(col_length.size() - 1);

		System.out.println(n1 * n2);
	}
}
