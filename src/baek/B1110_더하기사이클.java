package baek;

import java.util.Scanner;
/*
 * 백준 - 구현 
 * 
 */
public class B1110_더하기사이클 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt(); // 주어지는 입력 값

		int len = 0, next = N;
		while (true) {
			if (next / 10 + next % 10 < 10) // 각 자리 숫자의 합이 10보다 작으면, 
				next = (next % 10) * 10 + (next / 10 + next % 10); 
			else
				next = (next % 10) * 10 + (next / 10 + next % 10) % 10;
			
			len++; // 사이클의 길이 증가
			if (next == N) break; // 그 다음의 값이 처음 주어진 값 N 이랑 같으면 끝  
		}
		System.out.println(len);
	}
}
