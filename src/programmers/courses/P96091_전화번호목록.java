package programmers.courses;

import java.util.Arrays;

public class P96091_전화번호목록 {

	public static void main(String[] args) {
		String[] phone_book1 = {"119", "97674223", "1195524421"};
		System.out.println(solution(phone_book1));

		String[] phone_book2 = {"123", "456", "789"};
		System.out.println(solution(phone_book2));

		String[] phone_book3 = {"12", "123", "1235", "567", "88"};
		System.out.println(solution(phone_book3));
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
