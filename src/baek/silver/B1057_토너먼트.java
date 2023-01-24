package baek.silver;

import java.util.Scanner;

public class B1057_토너먼트 {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int N = scan.nextInt();
		int kim = scan.nextInt();
		int lim = scan.nextInt();
		int answer = 0;

		while (kim != lim) {
			kim = kim / 2 + kim % 2;
			lim = lim / 2 + lim % 2;
			answer++;
		}

		System.out.println(answer);
	}
}
