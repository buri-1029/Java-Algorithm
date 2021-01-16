package baek;

import java.util.Scanner;

public class B15649_NandM1 {
	/** 1부터 N까지 자연수 중에서 중복 없이 M개를 고른 수열 */		
	static int N, M;
	static int[] arr; 	// N까지 저장하는 배열
	static int[] sel;	// M개를 선택하는 배열
	static boolean[] v; // 방문 여부 배열
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);

		N = sc.nextInt();
		M = sc.nextInt();
		arr = new int[N];
		sel = new int[M];
		v = new boolean[N];
		
		for (int i = 0; i < N; i++) {
			arr[i] = i + 1;
		}

		recursive(0);
	}

	private static void recursive(int k) {
		// TODO Auto-generated method stub
		if (k == sel.length) {
			for (int i = 0; i < sel.length; i++) {
				System.out.print(sel[i] + " ");
			}
			System.out.println();
			return;
		}

		for (int i = 0; i < arr.length; i++) {
			if (v[i] != true) {
				v[i] = true;
				sel[k] = arr[i];
				recursive(k + 1);
				v[i] = false;
			}
		}
	}
}