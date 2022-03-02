package baek.silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 서로 다른 범위를 가지는 E S M이 주어졌을 때, 몇 년인지 구하는 문제
 */
public class B1476_날짜계산 {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int E = Integer.parseInt(st.nextToken());
		int S = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());

		int i = 1, e = 1, s = 1, m = 1;

		while (true) {
			if (E == e && S == s && M == m) {
				System.out.println(i);
				break;
			}
			e++;
			s++;
			m++;

			if (e == 16) {
				e = 1;
			}
			if (s == 29) {
				s = 1;
			}
			if (m == 20) {
				m = 1;
			}

			i++;
		}
	}
}
