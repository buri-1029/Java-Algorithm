package baek.silver;

import java.util.ArrayList;
import java.util.Scanner;

public class B1181_단어정렬 {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int N = scan.nextInt();

		ArrayList<String> words = new ArrayList<>();
		for (int i = 0; i < N; i++) {
			String inputStr = scan.next();
			if (!words.contains(inputStr)) {
				words.add(inputStr);
			}
		}

		words.sort((o1, o2) -> {
			if (o1.length() == o2.length()) {
				return o1.compareTo(o2);
			}
			return o1.length() - o2.length();
		});

		for (String word : words) {
			System.out.println(word);
		}
	}

}
