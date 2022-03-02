package baek.silver;

import java.util.Scanner;

/*
 * 다시 풀어보기
 * 문제 풀이 참고
 * https://velog.io/@seovalue/%EB%B0%B1%EC%A4%80-2564%EB%B2%88-%EA%B2%BD%EB%B9%84%EC%9B%90-python
 */
public class B2564_경비원 {

	static int res = 0;

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int width = sc.nextInt(); // 가로길이
		int height = sc.nextInt(); // 세로길이
		int cnt = sc.nextInt(); // 상점개수
		int[] store = new int[cnt + 1];

		for (int i = 0; i < cnt + 1; i++) {
			int dir = sc.nextInt();
			int dis = sc.nextInt();

			switch (dir) {
				case 1:
					store[i] = dis;
					break;
				case 2:
					store[i] = 2 * width + height - dis;
					break;
				case 3:
					store[i] = 2 * (width + height) - dis;
					break;
				case 4:
					store[i] = width + dis;
					break;
			}
		}
		int res = 0;
		for (int i = 0; i < cnt; i++) {
			int tmp = Math.abs(store[cnt] - store[i]);
			res += (tmp > (width + height)) ? 2 * (width + height) - tmp : tmp;
		}
		System.out.println(res);
	}
}
