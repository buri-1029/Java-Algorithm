package baek.silver;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class B1269_대칭차집합 {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int a = scan.nextInt();
		int b = scan.nextInt();

		Set<Integer> setA = new HashSet<>();
		Set<Integer> setB = new HashSet<>();

		for (int i = 0; i < a; i++) {
			setA.add(scan.nextInt());
		}

		for (int i = 0; i < b; i++) {
			setB.add(scan.nextInt());
		}

		int answer = 0;

		for (int num : setA) {
			if (!setB.contains(num)) {
				answer += 1;
			}
		}

		for (int num : setB) {
			if (!setA.contains(num)) {
				answer += 1;
			}
		}

		System.out.println(answer);
	}
}
