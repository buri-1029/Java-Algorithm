package swexpert;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class S1225_암호생성기 {
	static int tc;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		Queue<Integer> Q = new LinkedList<>();
		
		for(int T=0;T<10;T++) {
			Q.clear();
			tc = sc.nextInt();
			for(int n=0;n<8;n++) {
				Q.offer(sc.nextInt());
			}
			while(!Q.contains(0)) {
				for(int i=1;i<=5;i++) {
					if(Q.peek()-i<=0) {
						Q.poll(); Q.offer(0);
						break;
					}else {
						Q.offer(Q.poll()-i);
					}
				}
			}
			System.out.print("#"+tc+" ");
			for(Integer i : Q) {
				System.out.print(i + " ");
			}
			System.out.println();
		}
	}
}
