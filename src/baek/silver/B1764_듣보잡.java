package baek.silver;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.Scanner;

public class B1764_듣보잡 {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int N = scan.nextInt();
		int M = scan.nextInt();

		HashSet<String> set = new HashSet<>();
		for (int i = 0; i < N; i++) {
			set.add(scan.next());
		}

		ArrayList<String> answer = new ArrayList<>();
		for (int i = 0; i < M; i++) {
			String mStr = scan.next();
			if (set.contains(mStr)) {
				answer.add(mStr);
			}
		}

		Collections.sort(answer);

		System.out.println(answer.size());
		for (String s : answer) {
			System.out.println(s);
		}
	}

}
