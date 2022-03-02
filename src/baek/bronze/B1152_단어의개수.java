package baek.bronze;

import java.util.Scanner;

public class B1152_단어의개수 {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		String str = scan.nextLine();

		String[] arrStr = str.split(" ");
		int ans = arrStr.length;

		if (ans > 0 && arrStr[0].equals("")) {
			ans--;
		}

		System.out.println(ans);
	}

}
