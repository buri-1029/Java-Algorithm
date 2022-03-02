package baek.silver;

import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

public class B1427_소트인사이드 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();

		String strN = Integer.toString(N);
		String[] arrN = strN.split("");
		Arrays.sort(arrN, Collections.reverseOrder());

		String answer = "";
		for (String num : arrN) {
			answer += num;
		}
		System.out.println(answer);
	}

}
