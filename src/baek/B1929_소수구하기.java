package baek;

import java.util.Scanner;
/*
 * 	1부터 N까지 범위 안에 들어가는 모든 소수를 
 * 	구하려면 에라토스테네스의 체를 사용한다. 
 */
public class B1929_소수구하기 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int M = sc.nextInt();
		int N = sc.nextInt();

		boolean[] check = new boolean[N + 1];
		check[0] = check[1] = true;

		for (int i = 2; i * i <= N; i++) {
			if (check[i])	continue;

			for (int j = i + i; j <= N; j += i) {
				check[j] = true;
			}
		}
		for (int i = M; i <= N; i++) {
			if (check[i] == false) {
				System.out.println(i);
			}
		}
	}
}
