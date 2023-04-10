package programmers.level1;

import java.util.Arrays;
import java.util.HashMap;

public class P178871_달리기경주 {

	public static void main(String[] args) {
		String[] players = {"mumu", "soe", "poe", "kai", "mine"};
		String[] callings = {"kai", "kai", "mine", "mine"};
		System.out.println(Arrays.toString(solution(players, callings)));
	}

	public static String[] solution(String[] players, String[] callings) {
		/*
			List에 현재 등수를 저장하고 .indexOf() 메소드를 사용하여 callings 대상의 인덱스를 찾는 경우
			배열을 순회하며 찾기때문에 크기가 커지는 만큼 시간복잡도가 늘어납니다.

			ArrayList<String> list = new ArrayList<>(Arrays.asList(players));

			for (String calling : callings) {
				int cur = list.indexOf(calling);
				list.remove(cur);
				list.add(cur - 1, calling);
			}

			return list.toArray(new String[0]);
		 */

		HashMap<String, Integer> map = new HashMap<>();

		for (int i = 0; i < players.length; i++) {
			map.put(players[i], i);
		}

		for (String calling : callings) {
			int cur = map.get(calling);
			String front = players[cur - 1];

			players[cur - 1] = calling;
			players[cur] = front;

			map.put(calling, cur - 1);
			map.put(front, cur);

		}

		return players;
	}
}
