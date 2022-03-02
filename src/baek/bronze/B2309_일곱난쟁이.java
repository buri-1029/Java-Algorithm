package baek.bronze;

import java.util.Arrays;
import java.util.Scanner;

public class B2309_일곱난쟁이 {

	/**
	 * 일곱 난쟁이의 키 합은 100일 때, 아홉 명의 난쟁이 중 일곱 명의 난쟁이를 찾는 문제
	 */
	static int[] height = new int[9]; // 난쟁이들의 키를 저장하는 배열
	static int[] sel = new int[7]; // 일곱 난쟁이 선택할 배열
	static boolean[] visited = new boolean[height.length];

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		for (int i = 0; i < 9; i++) {
			height[i] = sc.nextInt();
		}
		select_Dwarfs(0, 0);
	}

	private static void select_Dwarfs(int idx, int k) {
		// TODO Auto-generated method stub
		int sum = 0;
		if (k == sel.length) { // 선택하는 개수가 7개(sel.length)가 되면
			for (int i = 0; i < sel.length; i++) {
				sum += sel[i]; // 선택되어진 난쟁이들의 키 모두 더하기
			}

			// 선택되어진 일곱 난쟁이들의 키의 총합이 100이면
			if (sum == 100) {
				Arrays.sort(sel); // 키를 오름차순으로 출력
				for (int i = 0; i < sel.length; i++) {
					System.out.println(sel[i]);
				}
			}
			return;
		}

		for (int i = idx; i < height.length; i++) {
			if (visited[i] != true) {
				visited[i] = true;
				sel[k] = height[i];
				select_Dwarfs(i + 1, k + 1);
				visited[i] = false;
			}
		}
	}
}
