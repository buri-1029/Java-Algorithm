package baek.silver;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class B1969_DNA {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int M = sc.nextInt();

		String[] dna = new String[N];

		for (int i = 0; i < N; i++) {
			dna[i] = sc.next();
		}

		String answer1 = "";

		for (int i = 0; i < M; i++) {
			Map<Character, Integer> map = new HashMap<>();
			for (int j = 0; j < N; j++) {
				map.put(dna[j].charAt(i), map.getOrDefault(dna[j].charAt(i), 0) + 1);
			}

			int cnt = 0;
			char tmp = 0;

			for (Character c : map.keySet()) {
				if (map.get(c) > cnt) {
					cnt = map.get(c);
					tmp = c;
				} else if (map.get(c) == cnt) {
					tmp = tmp > c ? c : tmp;
				}
			}

			answer1 += tmp;

		}

		System.out.println(answer1);

		int answer2 = 0;

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if (answer1.charAt(j) != dna[i].charAt(j)) {
					answer2++;
				}
			}
		}

		System.out.println(answer2);
	}
}
