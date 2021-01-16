package baek;

import java.util.PriorityQueue;
import java.util.Scanner;

public class B1715_카드정렬하기 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int ans = 0;
		
		PriorityQueue<Integer> card = new PriorityQueue<>();
		
		for (int i = 0; i < N; i++) {
			card.add(sc.nextInt());
		}
		
		while(card.size() != 1) {
			int n1 = card.poll();
			int n2 = card.poll();			
			card.add(n1+n2);
			ans+= (n1+n2);
		}
		System.out.println(ans);
	}
}
