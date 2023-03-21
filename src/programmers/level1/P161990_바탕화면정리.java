package programmers.level1;

import java.util.Arrays;

public class P161990_바탕화면정리 {

	public static void main(String[] args) {
		String[] wallpaper = {".#...", "..#..", "...#."};
		System.out.println(Arrays.toString(solution(wallpaper)));
	}

	public static int[] solution(String[] wallpaper) {
		int lux = Integer.MAX_VALUE, rdx = 0;
		int luy = Integer.MAX_VALUE, rdy = 0;

		for (int i = 0; i < wallpaper.length; i++) {
			String tmp = wallpaper[i];

			for (int j = 0; j < wallpaper[i].length(); j++) {
				if (tmp.charAt(j) == '#') {
					lux = Math.min(lux, i);
					luy = Math.min(luy, j);
					rdx = Math.max(rdx, i + 1);
					rdy = Math.max(rdy, j + 1);
				}
			}
		}

		return new int[]{lux, luy, rdx, rdy};
	}
}
