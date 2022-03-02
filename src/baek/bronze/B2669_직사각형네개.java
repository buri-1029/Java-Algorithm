package baek.bronze;

import java.util.Scanner;

public class B2669_직사각형네개 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);

		int[][] arr = new int[101][101];

		for (int n = 0; n < 4; n++) {
			int lx = sc.nextInt();
			int ly = sc.nextInt();
			int rx = sc.nextInt();
			int ry = sc.nextInt();

			for (int i = ly; i < ry; i++) {
				for (int j = lx; j < rx; j++) {
					arr[i][j] = 1;
				}
			}
		}

		int ans = 0;
		for (int i = 0; i < arr.length; i++) {
			for (int j = 0; j < arr[i].length; j++) {
				if (arr[i][j] == 1) {
					ans++;
				}
			}
		}
		System.out.println(ans);
	}
}
