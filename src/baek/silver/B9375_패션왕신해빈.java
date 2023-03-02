package baek.silver;

import java.util.HashMap;
import java.util.Scanner;

public class B9375_패션왕신해빈 {

	public static void main(String[] args) {

		Scanner scan = new Scanner(System.in);
		int T = scan.nextInt();

		while (T-- > 0) {
			HashMap<String, Integer> map = new HashMap<>();
			int N = scan.nextInt();

			while (N-- > 0) {
				scan.next();
				String kind = scan.next();

				if (map.containsKey(kind)) {
					map.put(kind, map.get(kind) + 1);
				} else {
					map.put(kind, 1);
				}
			}

			int answer = 1;

			for (int n : map.values()) {
				answer *= (n + 1);
			}

			System.out.println(answer - 1);
		}
	}
}
