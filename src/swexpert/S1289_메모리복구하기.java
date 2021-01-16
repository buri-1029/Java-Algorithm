package swexpert;

import java.util.Scanner;

public class S1289_메모리복구하기 {
	/** bit : 1->0 & 0->1 */

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);

		int T = sc.nextInt();
		for (int tc = 1; tc <= T; tc++) {
			String str = sc.next();
			int[] bit = new int[str.length()]; // 입력받은 bit 저장할 배열
			int temp = 0;  // 초기화 상태 : 0	
			int cnt = 0;   // 수정 횟수

			for (int i = 0; i < str.length(); i++) {
				bit[i] = str.charAt(i) - '0';
				if (bit[i] != temp) { // 이전 bit(temp)와 비교해서 다르면
					cnt++; 			  // 수정 횟수 증가
					temp = bit[i];	  // temp에 현재 bit로 저장
				}
			}
			System.out.println("#" + tc + " " + cnt);
		}
	}
}
