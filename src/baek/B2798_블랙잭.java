package baek;

import java.util.Scanner;

public class B2798_블랙잭 {
	/** 블랙잭 : 입력받은 카드 수 중에서 입력받은 수만큼 뽑았을 때 가장 큰 값  */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();
		int M = sc.nextInt();
		int[] cards = new int[N]; 
		
		int SUM = 0;
		int MAX = 0;
		
		for(int i=0;i<N;i++) {
			cards[i] = sc.nextInt();
		}
		
		for(int a=0;a<N;a++) {
			for(int b=a+1;b<N;b++) {
				for(int c=b+1;c<N;c++) {
					SUM = cards[a]+cards[b]+cards[c];
					if(MAX<SUM && SUM<=M) {
						MAX = SUM;
					}
				}
			}
		}
		System.out.println(MAX);
	}
}
