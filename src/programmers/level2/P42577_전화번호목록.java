package programmers.level2;

import java.util.HashMap;
import java.util.Map;

public class P42577_전화번호목록 {

	public static void main(String[] args) {
		String[] phone_book1 = {"119", "97674223", "1195524421"};
		String[] phone_book2 = {"12", "123", "1235", "567", "88"};

		System.out.println(solution(phone_book1));
		System.out.println(solution(phone_book2));
	}

	private static boolean solution(String[] phone_book) {
		Map<String, Integer> map = new HashMap<>();

		for (int i = 0; i < phone_book.length; i++) {
			map.put(phone_book[i], i);
		}

		for (int i = 0; i < phone_book.length; i++) {
			for (int j = 0; j < phone_book[i].length(); j++) {
				if (map.containsKey(phone_book[i].substring(0, j))) {
					return false;
				}
			}
		}
		return true;
	}
}
