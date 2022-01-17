package programmers.Level2;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class P42888_오픈채팅방 {

	public static void main(String[] args) {
		String[] record = {"Enter uid1234 Muzi", "Enter uid4567 Prodo", "Leave uid1234",
			"Enter uid1234 Prodo", "Change uid4567 Ryan"};

		solution(record);
	}

	private static String[] solution(String[] record) {
		Map<String, String> map = new HashMap<>();
		ArrayList<String> list = new ArrayList<>();

		for (int i = 0; i < record.length; i++) {
			String[] tmp = record[i].split(" ");
			if (tmp.length > 2) {
				map.put(tmp[1], tmp[2]);
			}
		}

		for (int i = 0; i < record.length; i++) {
			String[] tmp = record[i].split(" ");
			if (tmp[0].equals("Enter")) {
				list.add(map.get(tmp[1]) + "님이 들어왔습니다.");
			} else if (tmp[0].equals("Leave")) {
				list.add(map.get(tmp[1]) + "님이 나갔습니다.");
			}
		}

		String[] answer = new String[list.size()];
		return list.toArray(answer);
	}

}
