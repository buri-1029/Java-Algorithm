package swexpert;

import java.util.ArrayList;
import java.util.Scanner;

public class S5643_키순서 {
	static int T, N, M, Ans;
	static int bcnt, scnt;
	static boolean[] big_visit, small_visit;
	static ArrayList<Integer>[] big, small;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		T = sc.nextInt();
		
		for(int tc = 1; tc <= T; tc++) {
			N = sc.nextInt();
			M = sc.nextInt();
			Ans = 0;
			
			big = new ArrayList[N + 1];
			small = new ArrayList[N + 1];
			for(int i = 1; i < N + 1; i++) {
				big[i] = new ArrayList<>();
				small[i] = new ArrayList<>();
			}
			
			for(int i = 1; i < M + 1; i++) {
				int a = sc.nextInt();
				int b = sc.nextInt();
				big[a].add(b);
				small[b].add(a);
			}	
			for(int i = 1; i < N + 1; i++) {
				big_visit = new boolean[N + 1];
				small_visit = new boolean[N + 1];
				bcnt = -1; scnt = -1;
				big_dfs(i);
				small_dfs(i);
				if(bcnt + scnt == N - 1) Ans++;
			}
			System.out.println("#"+tc+" "+Ans);
		}
	}
	private static void big_dfs(int idx) {
		bcnt++;
		big_visit[idx] = true;
		int size = big[idx].size();
		for(int i = 0; i < size; i++) {
			Integer n = big[idx].get(i);
			if(!big_visit[n]) {
				big_dfs(n);
			}
		}
	}
	private static void small_dfs(int idx) {
		scnt++;
		small_visit[idx] = true;
		int size = small[idx].size();
		for(int i = 0; i < size; i++) {
			Integer n = small[idx].get(i);
			if(!small_visit[n]) {
				small_dfs(n);
			}
		}
	}
}