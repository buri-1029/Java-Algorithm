package baek;

import java.util.Scanner;

/** 
 * 양의 정수 n개의 가능한 모든 쌍의 GCD의 합 
 * 
 */
public class B9613_GCD합 {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for (int tc = 0; tc < T; tc++) {
			long sum = 0;
			int N = sc.nextInt();
			int[] arr = new int[N];
			for (int i = 0; i < N; i++) {
				arr[i] = sc.nextInt();
			}
			
			for (int i = 0; i < N - 1; i++) {
				for (int j = i + 1; j < N; j++) {
					int a = arr[i];
					int b = arr[j]; 
					while (b > 0) { // 유클리드
						int temp = b;
						b = a % b;
						a = temp;
					}
					sum+=a; // 모든 쌍의 GCD의 합
				}
			}
			System.out.println(sum);
		}
	}
}
