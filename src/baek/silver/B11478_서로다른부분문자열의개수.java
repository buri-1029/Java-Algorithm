package baek.silver;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class B11478_서로다른부분문자열의개수 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String str = sc.next();

		Set<String> set = new HashSet<>();

		for (int i = 0; i < str.length(); i++) {
			for (int j = i; j < str.length(); j++) {
				set.add(str.substring(i, j + 1));
			}
		}

		System.out.println(set.size());
	}

}
