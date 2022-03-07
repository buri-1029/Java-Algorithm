package baek.bronze;

import java.util.ArrayList;
import java.util.Scanner;

public class B2501_약수구하기 {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int N = scan.nextInt();
		int K = scan.nextInt();

		ArrayList<Integer> measure = new ArrayList<>();
		for (int i = 1; i <= N; i++) {
			if (N % i == 0) {
				measure.add(i);
			}
		}

		if (measure.size() < K) {
			System.out.println(0);
		} else {
			System.out.println(measure.get(K - 1));
		}
	}

}
