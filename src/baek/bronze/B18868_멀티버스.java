package baek.bronze;

import java.util.Scanner;

public class B18868_멀티버스 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int M = sc.nextInt();
		int N = sc.nextInt();

		int[][] arr = new int[M][N];
		for (int i = 0; i < M; i++) {
			for (int j = 0; j < N; j++) {
				arr[i][j] = sc.nextInt();
			}
		}
		int answer = 0;
		for (int i = 0; i < M - 1; i++) {
			for (int j = i + 1; j < M; j++) {
                if (!compare(arr[i], arr[j], N)) {
                    answer++;
                }

			}
		}
		System.out.println(answer);
	}

	private static boolean compare(int[] arr1, int[] arr2, int N) {
		for (int i = 0; i < N - 1; i++) {
			for (int j = i + 1; j < N; j++) {
				if (arr1[i] > arr1[j]) {
					if (arr2[i] <= arr2[j]) {
						return true;
					}
				} else if (arr1[i] < arr1[j]) {
					if (arr2[i] >= arr2[j]) {
						return true;
					}
				} else {
					if (arr2[i] != arr2[j]) {
						return true;
					}
				}
			}
		}
		return false;
	}
}
