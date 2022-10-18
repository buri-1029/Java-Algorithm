package baek.silver;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class B10814_나이순정렬 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();

		List<Member> list = new ArrayList<>();

		for (int i = 0; i < N; i++) {
			list.add(new Member(sc.nextInt(), sc.next()));
		}

		Collections.sort(list);

		for (Member m : list) {
			System.out.println(m.age + " " + m.name);
		}

	}

	static class Member implements Comparable<Member> {

		int age;
		String name;

		public Member(int age, String name) {
			this.age = age;
			this.name = name;
		}

		@Override
		public int compareTo(Member o) {
			return this.age - o.age;
		}
	}
}
