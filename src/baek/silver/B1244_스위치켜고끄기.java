package baek.silver;

import java.util.Scanner;

public class B1244_스위치켜고끄기 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt(); // 스위치 개수
		int[] state = new int[N + 1]; // 각 스위치 상태 저장 배열

		for (int i = 1; i <= N; i++) {
			state[i] = sc.nextInt(); // 입력 받기
		}

		int STU = sc.nextInt(); // 학생 수

		for (int i = 0; i < STU; i++) {
			int gender = sc.nextInt();
			int num = sc.nextInt();

			if (gender == 1) {
				for (int j = num; j <= N; j += num) {
					state[j] = state[j] == 0 ? 1 : 0;// 반전
				}
			} else {
				int left = num, right = num; // 좌우 대칭이 같은 번호인지 확인하기 위한 변수

				/* ****************************************************************** */
				while (left > 1 && right < N && state[left - 1] == state[right + 1]) {
					left--;
					right++;
				}
				for (int j = left; j <= right; j++) {
					state[j] = state[j] == 0 ? 1 : 0;// 반전
				}
			}
		}
		for (int i = 1; i <= N; i++) {
			System.out.print(state[i] + " ");
			if (i % 20 == 0) {
				System.out.println();
			}
		}
	}
}
