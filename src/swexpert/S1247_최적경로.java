package swexpert;

import java.util.Arrays;
import java.util.Scanner;

public class S1247_최적경로 {
	static int T, N, MIN;
	static int home_x, home_y, company_x,company_y;
	static int[] X, Y;
	static int[] sel1, sel2;
	static boolean v[]; 
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		
		T = sc.nextInt();
		for(int tc=1;tc<=T;tc++) {
			N = sc.nextInt();
			
			v = new boolean[N];
			X = new int[N];
			Y = new int[N];
			sel1 = new int[N];
			sel2 = new int[N];
			
			//회사위치 입력
			company_x = sc.nextInt(); 
			company_y = sc.nextInt();
			
			//집위치 입력
			home_x = sc.nextInt();
			home_y = sc.nextInt();
			
			for(int i=0;i<N;i++) {
				X[i] = sc.nextInt();
				Y[i] = sc.nextInt();
			}
			MIN = 1000000;
			recursive(0,0,company_x ,company_y);
			System.out.println("#"+tc+" "+MIN);
		}
	}
	private static void recursive(int k, int sum, int x, int y) {
		// TODO Auto-generated method stub
		if(k == sel1.length) {
			sum+=Math.abs(x-home_x) + Math.abs(y-home_y);
			MIN = Math.min(sum, MIN);
			return;
		}

		for(int i=0;i<N;i++) {
			if(v[i] != true) {
				v[i] = true;
				sel1[k] = X[i];
				sel2[k] = Y[i];
				recursive(k+1,sum+Math.abs(x-sel1[k])+Math.abs(y-sel2[k]),sel1[k],sel2[k]);
				v[i] = false;
			}
		}
	}
}

