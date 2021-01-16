package swexpert;

import java.util.Scanner;

//민석이의 과제 체크하기
public class S5431_과제체크하기 {
	static int T, N, K, n;
	static int[] OK;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		int T, N, K, n;
		int[] OK;
		Scanner sc = new Scanner(System.in);
		
		T = sc.nextInt();
		for(int tc=1;tc<T+1;tc++) {
			N = sc.nextInt();
			OK = new int[N];
			
			K = sc.nextInt();
			for(int k=0;k<K;k++) {
				 n = sc.nextInt();
				 OK[n-1] = 1;
			}			
			for(int i=0;i<N;i++) {
				if(OK[i] != 1) {
					System.out.print(i+1 + " ");
				}
			}
			System.out.println();
		}
	}
}
