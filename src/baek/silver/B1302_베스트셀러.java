package baek.silver;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;

public class B1302_베스트셀러 {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int N = scan.nextInt();
		HashMap<String, Integer> map = new HashMap<>();

		for (int i = 0; i < N; i++) {
			String str = scan.next();

			if (map.containsKey(str)) {
				map.replace(str, map.get(str) + 1);
			} else {
				map.put(str, 1);
			}
		}

		int max = 0;
		for (String a : map.keySet()) {
			max = Math.max(max, map.get(a));
		}

		List<String> al = new ArrayList<>(map.keySet());
		Collections.sort(al);

		for (String a : al) {
			if (map.get(a) == max) {
				System.out.println(a);
				break;
			}
		}
	}
}
