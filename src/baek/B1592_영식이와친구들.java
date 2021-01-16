package baek;

import java.util.Scanner;

public class B1592_영식이와친구들 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int[] ball = new int[N];
		int index = 0,sum = 0;
		ball[index] = 1;
		
		int M = sc.nextInt(); int L = sc.nextInt();
		
		while(true) {
			if(ball[index]==M) {
				break;
			}else if(ball[index]%2==1) {
				index =(index+L)%N;
				ball[index]++;
				sum++;
			}else if(ball[index]%2==0) {	
				index =(index-L+N)%N;
				ball[index]++;
				sum++;
			}
		}
		System.out.println(sum);		
	}
}
