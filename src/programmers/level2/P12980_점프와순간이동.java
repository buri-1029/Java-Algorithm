package programmers.level2;

/**
 * 최대한 많은 순간이동 == 짝수(현재 이동거리 x 2) & 점프 최소 == 홀수(k칸 앞으로 이동)
 */
public class P12980_점프와순간이동 {

	public static void main(String[] args) {
		int N1 = 5;
		int N2 = 6;
		int N3 = 5000;

		System.out.println(solution(N1));
		System.out.println(solution(N2));
		System.out.println(solution(N3));

	}

	public static int solution(int n) {
		int ans = 0;

		while (n > 0) {
			if (n % 2 == 1) {
				ans++;
			}

			n /= 2;
		}

		return ans;
	}

}
