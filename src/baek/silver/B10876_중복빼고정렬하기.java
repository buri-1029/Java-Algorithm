package baek.silver;

import java.util.Scanner;
import java.util.TreeSet;

public class B10876_중복빼고정렬하기 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();

		TreeSet<Integer> set = new TreeSet<>();

		for (int i = 0; i < N; i++) {
			set.add(sc.nextInt());
		}

		for (Integer integer : set) {
			System.out.print(integer + " ");
		}
	}

}
