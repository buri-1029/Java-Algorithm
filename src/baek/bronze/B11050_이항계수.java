package baek.bronze;

import java.util.Scanner;

/*
    이항계수(조합의 가짓수) : nCr
    dp방법으로도 풀어보기!
 */
public class B11050_이항계수 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int K = sc.nextInt();

		int ans = 0;
		ans = factorial(N) / (factorial(K) * factorial(N - K));
		System.out.println(ans);
	}

	private static int factorial(int n) {
        if (n == 0 || n == 1) {
            return 1;
        }
		return n * factorial(n - 1);
	}
}
