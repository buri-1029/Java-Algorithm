package baek.silver;

import java.util.Scanner;

public class B1541_잃어버린괄호 {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		String inputStr = scan.next();

		String[] arrStr;
		int answer;

		if (inputStr.contains("-")) {
			arrStr = inputStr.split("-");
			answer =
				arrStr[0].contains("+") ? checkPlusNum(arrStr[0]) : Integer.parseInt(arrStr[0]);

			for (int i = 1; i < arrStr.length; i++) {
				if (arrStr[i].contains("+")) {
					answer -= checkPlusNum(arrStr[i]);
				} else {
					answer -= Integer.parseInt(arrStr[i]);
				}
			}
		} else {
			answer = checkPlusNum(inputStr);
		}

		System.out.println(answer);
	}

	private static int checkPlusNum(String s) {
		String[] arrStr = s.split("\\+");
		int tmp = 0;

		for (int i = 0; i < arrStr.length; i++) {
			tmp += Integer.parseInt(arrStr[i]);
		}

		return tmp;
	}

}
