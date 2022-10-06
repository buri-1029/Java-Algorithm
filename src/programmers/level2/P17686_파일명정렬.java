package programmers.level2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class P17686_파일명정렬 {

	public static void main(String[] args) {
		String[] files1 = {"img12.png", "img10.png", "img02.png", "img1.png", "IMG01.GIF",
			"img2.JPG"};

		String[] files2 = {"F-5 Freedom Fighter", "B-50 Superfortress", "F-15 ",
			"A-10 Thunderbolt II",
			"F-14 Tomcat"};

		System.out.println(Arrays.toString(solution(files1)));
		System.out.println(Arrays.toString(solution(files2)));

	}

	public static String[] solution(String[] files) {
		String[] answer = new String[files.length];
		List<File> list = new ArrayList<>();

		for (String file : files) {
			String tmp1 = file.replaceFirst("[^0-9]*", "");
			int differ1 = file.length() - tmp1.length();
			String head = file.substring(0, file.length() - tmp1.length());

			String tmp2 = tmp1.replaceFirst("^[0-9]*", "");
			int differ2 = file.length() - tmp2.length();
			String number = file.substring(differ1, differ2);

			String tail = file.substring(differ2);

			list.add(new File(head, number, tail));
		}

		Collections.sort(list);

		int idx = 0;
		for (File file : list) {
			answer[idx++] = file.head + file.number + file.tail;
		}

		return answer;
	}

	static class File implements Comparable<File> {

		String head;
		String number;
		String tail;

		public File(String head, String number, String tail) {
			this.head = head;
			this.number = number;
			this.tail = tail;
		}

		@Override
		public int compareTo(File o) {

			if (!head.equalsIgnoreCase(o.head)) { // *****
				return head.compareToIgnoreCase(o.head);
			}

			return Integer.compare(Integer.parseInt(number), Integer.parseInt(o.number));
		}
	}
}
