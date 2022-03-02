package baek.gold;

import java.util.ArrayList;
import java.util.Scanner;

/*
 *  다시 생각해보기
 */
public class B1038_감소하는수 {

	static ArrayList<Long> list = new ArrayList<>();

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();

		for (long i = 0; i <= 9; i++) {
			solution("" + i, i);
			list.add(i);
		}

		list.sort(null);
		if (list.size() <= N) {
			System.out.println(-1);
		} else {
			System.out.println(list.get(N));
		}
	}

	private static void solution(String num, long idx) {
		for (int i = 0; i < idx; i++) {
			list.add(Long.parseLong(num + i));
			solution(num + i, i);
		}
	}
}
