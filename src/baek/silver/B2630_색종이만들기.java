package baek.silver;

import java.util.Scanner;

public class B2630_색종이만들기 {

	static int N, cnt1 = 0, cnt2 = 0; // cnt1 : 하얀색 , cnt2 : 파란색
	static int[][] map;

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		map = new int[N][N];

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				map[i][j] = sc.nextInt();
			}
		}
		paper(N, 0, 0);
		System.out.println(cnt1);
		System.out.println(cnt2);

	}

	private static void paper(int n, int i, int j) {
		// TODO Auto-generated method stub
		boolean blue = true;
		boolean white = true;

		// 모두 같은 색으로 칠해져있는지 확인
		for (int p = i; p < i + n; p++) {
			for (int q = j; q < j + n; q++) {
				if (map[p][q] == 0) {
					blue = false;
				} else {
					white = false;
				}
			}
		}

		if (white) { // 모두 하얀색으로 칠해져 있으면 cnt1 증가
			cnt1++;
		} else if (blue) { // 모두 파란색으로 칠해져 있으면 cnt2 증가
			cnt2++;
		} else { // 그렇지 않으면 또 네 영역으로 나누어 확인
			paper(n / 2, i, j);                // 왼쪽 위
			paper(n / 2, i, j + n / 2);            // 오른쪽 위
			paper(n / 2, i + n / 2, j);            // 왼쪽 아래
			paper(n / 2, i + n / 2, j + n / 2);    // 오른쪽 아래
		}
		return;
	}
}
