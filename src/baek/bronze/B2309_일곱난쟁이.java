package baek.bronze;

import java.util.Arrays;
import java.util.Scanner;

public class B2309_일곱난쟁이 {

	/**
	 * 일곱 난쟁이의 키 합은 100일 때, 아홉 명의 난쟁이 중 일곱 명의 난쟁이를 찾는 문제
	 */

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int[] height = new int[9];
		int sum = 0;

		for (int i = 0; i < 9; i++) {
			height[i] = sc.nextInt();
			sum += height[i];
		}

		int a = 0, b = 0;
		for (int i = 0; i < height.length; i++) {
			for (int j = i + 1; j < height.length; j++) {
				if (sum - height[i] - height[j] == 100) {
					a = height[i];
					b = height[j];
					break;
				}
			}
		}

		Arrays.sort(height);

		for (int num : height) {
			if (num == a || num == b) {
				continue;
			}
			System.out.println(num);
		}
	}

}
