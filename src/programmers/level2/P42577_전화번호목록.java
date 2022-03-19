package programmers.level2;

import java.util.Arrays;

public class P42577_전화번호목록 {

	public static void main(String[] args) {
		String[] phone_book1 = {"119", "97674223", "1195524421"};
		String[] phone_book2 = {"12", "123", "1235", "567", "88"};

		System.out.println(solution(phone_book1));
		System.out.println(solution(phone_book2));
	}

	private static boolean solution(String[] phone_book) {
		Arrays.sort(phone_book);

		for (int i = 1; i < phone_book.length; i++) {
			if (phone_book[i].startsWith(phone_book[i - 1])) {
				return false;
			}
		}

		return true;
	}
}
