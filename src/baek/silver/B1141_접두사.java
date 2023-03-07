package baek.silver;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Scanner;

public class B1141_접두사 {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int n = scan.nextInt();
		String[] arr = new String[n];

		for (int i = 0; i < n; i++) {
			arr[i] = scan.next();
		}

		Arrays.sort(arr, (s1, s2) -> Integer.compare(s2.length(), s1.length()));

		HashSet<String> set = new HashSet<>();
		for (String s1 : arr) {
			if (set.size() == 0) {
				set.add(s1);
				continue;
			}

			boolean flag = true;
			for (String s2 : set) {
				if (s2.indexOf(s1) == 0) {
					flag = false;
					break;
				}
			}

			if (flag) {
				set.add(s1);
			}
		}

		System.out.println(set.size());
	}
}
