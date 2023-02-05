package programmers.level2;

import java.util.HashSet;

public class P49994_방문길이 {

	public static void main(String[] args) {
		System.out.println(solution("ULURRDLLU"));
		System.out.println(solution("LULLLLLLU"));
	}

	public static int solution(String dirs) {
		int answer = 0;

		Pos pos = new Pos(0, 0);
		HashSet<String> set = new HashSet<>();

		for (char c : dirs.toCharArray()) {
			if (c == 'U' && pos.y < 5) {
				pos.y++;
				String str = pos.x + "," + (pos.y - 0.5);
				set.add(str);
			} else if (c == 'D' && pos.y > -5) {
				pos.y--;
				String str = pos.x + "," + (pos.y + 0.5);
				set.add(str);
			} else if (c == 'R' && pos.x < 5) {
				pos.x++;
				String str = (pos.x - 0.5) + "," + pos.y;
				set.add(str);
			} else if (c == 'L' && pos.x > -5) {
				pos.x--;
				String str = (pos.x + 0.5) + "," + pos.y;
				set.add(str);
			}
		}

		answer = set.size();

		return answer;
	}

	public static class Pos {

		int x;
		int y;

		public Pos(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}
}

