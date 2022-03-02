package baek.silver;

import java.util.Scanner;

public class B17136_색종이붙이기 {

	static int[][] map = new int[10][10];
	static int[] paper = {0, 5, 5, 5, 5, 5};
	static int res = Integer.MAX_VALUE;
	//	static int[] dr = {0,1,1};
	//	static int[] dc = {1,1,0};

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);

		for (int i = 0; i < 10; i++) {
			for (int j = 0; j < 10; j++) {
				map[i][j] = sc.nextInt();
			}
		}

		dfs(0, 0, 0);
		System.out.println(res);
	}

	private static void dfs(int r, int c, int cnt) {
		// TODO Auto-generated method stub
		for (int i = r; i < 10; i++) {
			for (int j = c; j < 10; j++) {
				if (map[i][j] == 1) {
					for (int k = 5; k >= 1; k--) {
						//......
					}
				}
			}
		}
	}

}
