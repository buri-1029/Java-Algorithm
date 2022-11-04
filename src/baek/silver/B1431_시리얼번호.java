package baek.silver;

import java.util.ArrayList;
import java.util.Scanner;

public class B1431_시리얼번호 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();

		ArrayList<String> list = new ArrayList<>();
		for (int i = 0; i < N; i++) {
			list.add(sc.next());
		}

		list.sort((o1, o2) -> {
			if (o1.length() == o2.length()) {
				int sum1 = 0;
				int sum2 = 0;

				for (int i = 0; i < o1.length(); i++) {
					if (o1.charAt(i) <= '9' && o1.charAt(i) >= '0') {
						sum1 += Integer.parseInt(String.valueOf(o1.charAt(i)));
					}
				}
				for (int i = 0; i < o2.length(); i++) {
					if (o2.charAt(i) <= '9' && o2.charAt(i) >= '0') {
						sum2 += Integer.parseInt(String.valueOf(o2.charAt(i)));
					}
				}
				if (sum1 == sum2) {
					return o1.compareTo(o2);
				} else {
					return sum1 - sum2;
				}
			} else {
				return o1.length() - o2.length();
			}

		});

		for (String str : list) {
			System.out.println(str);
		}
	}

}
