package baek.bronze;

import java.util.Scanner;

public class B2991_사나운개 {

	/**
	 * 사나운 개
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);

		int A = sc.nextInt();
		int B = sc.nextInt();
		int C = sc.nextInt();
		int D = sc.nextInt();

		int[] workers = new int[3];
		int[] dog = new int[3];
		int max = 0;
		for (int i = 0; i < 3; i++) {
			workers[i] = sc.nextInt();
		}

		/**반복되는 구간있으면 %연산 사용하기!*/
		for (int i = 0; i < 3; i++) {
			if (workers[i] % (A + B) <= A && workers[i] % (A + B) > 0) {
				dog[i]++;
			}
			if (workers[i] % (C + D) <= C && workers[i] % (C + D) > 0) {
				dog[i]++;
			}
			System.out.println(dog[i]);
		}
	}
}
