package baek.silver;

import java.util.Scanner;

public class B1978_소수찾기 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int cnt = 0;
		for (int i = 0; i < N; i++) {
			int num = sc.nextInt();
			if (prime(num)) {
				cnt++;
			}
		}
		System.out.println(cnt);
	}

	private static boolean prime(int num) {
		if (num < 2) {
			return false;
		}
		for (int i = 2; i * i <= num; i++) {
			if (num % i == 0) {
				return false;
			}
		}
		return true;
	}
}
