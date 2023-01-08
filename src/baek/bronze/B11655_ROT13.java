package baek.bronze;

import java.util.Scanner;

public class B11655_ROT13 {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		String str = scan.nextLine();

		char arr[] = str.toCharArray();

		for (int i = 0; i < arr.length; i++) {
			if (arr[i] >= 'a' && arr[i] <= 'm') {
				arr[i] += 13;
			} else if (arr[i] >= 'n' && arr[i] <= 'z') {
				arr[i] -= 13;
			} else if (arr[i] >= 'A' && arr[i] <= 'M') {
				arr[i] += 13;
			} else if (arr[i] >= 'N' && arr[i] <= 'Z') {
				arr[i] -= 13;
			}
		}

		System.out.println(arr);
	}
}
