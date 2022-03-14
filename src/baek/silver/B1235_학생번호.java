package baek.silver;

import java.util.ArrayList;
import java.util.Scanner;

public class B1235_학생번호 {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int N = scan.nextInt();
		ArrayList<String> arr = new ArrayList<>();

		for (int i = 0; i < N; i++) {
			arr.add(scan.next());
		}

		int len = arr.get(0)
					 .length();

		int answer = 0;
		for (int i = 0; i <= len; i++) {
			boolean flag = true;
			for (int j = 0; j < N; j++) {
				if (i != 0) {
					String tmp = arr.get(j)
									.substring(1);
					if (arr.contains(tmp)) {
						arr.set(j, tmp);
						flag = false;
						break;
					}
					arr.set(j, tmp);
				}
			}

			if (flag) {
				answer = len - i;
			}
		}

		System.out.println(answer);

	}

}
