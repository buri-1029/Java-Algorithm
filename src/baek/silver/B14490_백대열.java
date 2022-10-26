package baek.silver;

import java.util.Scanner;

public class B14490_백대열 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String str = sc.nextLine();

		String[] arr = str.split(":");

		int originA = Integer.parseInt(arr[0]);
		int originB = Integer.parseInt(arr[1]);
		int a = originA;
		int b = originB;

		while (b > 0) {
			int tmp = b;
			b = a % b;
			a = tmp;
		}

		System.out.println(originA / a + ":" + originB / a);
	}

}
