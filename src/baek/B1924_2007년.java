package baek;

import java.util.Scanner;
/*
 * 백준 - 구현
 * 
 */
public class B1924_2007년 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int month = sc.nextInt();
		int day = sc.nextInt();
		
		int sum = 0;
		
		int[] months = {0, 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
		String[] ans = {"SUN", "MON", "TUE", "WED", "THU", "FRI", "SAT"};
		
		for(int i = 1; i <= 12; i++) {
			if(i == month) break;
			sum += months[i];
		}
		
		sum += day;
		int  tmp = sum%7;
		
		System.out.println(ans[tmp]);
	}
}
