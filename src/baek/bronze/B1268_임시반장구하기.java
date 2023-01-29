package baek.bronze;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class B1268_임시반장구하기 {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int N = scan.nextInt();

		int[][] arr = new int[N][5];
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < 5; j++) {
				arr[i][j] = scan.nextInt();
			}
		}

		int max = 0;
		int answer = 0;

		for (int i = 0; i < N; i++) {
			Set<Integer> set = new HashSet<>();

			for (int j = 0; j < 5; j++) {
				for (int k = 0; k < N; k++) {
					if (arr[i][j] == arr[k][j] && k != i) {
						set.add(k);
					}
				}
			}

			if (max < set.size()) {
				max = set.size();
				answer = i;
			}
		}

		System.out.println(answer + 1);
	}
}
