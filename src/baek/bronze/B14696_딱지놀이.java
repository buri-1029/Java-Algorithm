package baek.bronze;

import java.util.Scanner;

public class B14696_딱지놀이 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();    // 총 라운드 수
		char[] ans = new char[N]; // 각 라운드 결과

		for (int round = 0; round < N; round++) {
			int[] A = new int[5]; // 어린이 A의 딱지의 그림 저장 
			int[] B = new int[5]; // 어린이 B의 딱지의 그림 저장
			// index 4: 별 3: 동그라미 2: 네모 1: 세모

			int a = sc.nextInt();
			for (int i = 0; i < a; i++) {
				A[sc.nextInt()]++;
			}
			int b = sc.nextInt();
			for (int i = 0; i < b; i++) {
				B[sc.nextInt()]++;
			}

			// 규칙에 따른 어느 쪽이 강력한지 결정하기
			if (A[4] != B[4]) {
				ans[round] = (A[4] > B[4]) ? 'A' : 'B';
			} else if (A[3] != B[3]) {
				ans[round] = (A[3] > B[3]) ? 'A' : 'B';
			} else if (A[2] != B[2]) {
				ans[round] = (A[2] > B[2]) ? 'A' : 'B';
			} else if (A[1] != B[1]) {
				ans[round] = (A[1] > B[1]) ? 'A' : 'B';
			} else {
				ans[round] = 'D';
			}
		}

		for (int round = 0; round < N; round++) {
			System.out.println(ans[round]);
		}
	}
}
