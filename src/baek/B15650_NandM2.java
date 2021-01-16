package baek;

import java.util.Scanner;

public class B15650_NandM2 {
	/** 1부터 N까지 자연수 중에서 중복 없이 M개를 고른 수열 (중복x) */
	static int N, M;
	static int[] arr;
	static int[] sel;

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);

		N = sc.nextInt();
		M = sc.nextInt();
		arr = new int[N];
		sel = new int[M];

		for (int i = 0; i < N; i++) {
			arr[i] = i + 1;
		}
		
		recursive(0, 0);
	}

	private static void recursive(int idx, int k) {
		// TODO Auto-generated method stub
		if (k == sel.length) {
			for (int i = 0; i < sel.length; i++) {
				System.out.print(sel[i] + " ");
			}
			System.out.println();
			return;
		}
		
		if (idx == arr.length) {
			return;
		}

		sel[k] = arr[idx];
		// 뽑는경우
		recursive(idx + 1, k + 1);
		// 안뽑는경우
		recursive(idx + 1, k);
	}
}