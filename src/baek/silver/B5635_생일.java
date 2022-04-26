package baek.silver;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class B5635_생일 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		List<Student> list = new ArrayList<>();

		for (int i = 0; i < n; i++) {
			String str = br.readLine();
			String[] arr = str.split(" ");
			String tmp = arr[3] +
				(Integer.parseInt(arr[2]) < 10 ? "0" + arr[2] : arr[2]) +
				(Integer.parseInt(arr[1]) < 10 ? "0" + arr[1] : arr[1]);

			list.add(new Student(arr[0], tmp));
		}

		Collections.sort(list);
		System.out.println(list.get(n - 1).name);
		System.out.println(list.get(0).name);
	}

	static class Student implements Comparable<Student> {

		String name;
		String birth;

		public Student(String name, String birth) {
			this.name = name;
			this.birth = birth;
		}

		@Override
		public int compareTo(Student o) {
			return this.birth.compareTo(o.birth);
		}
	}
}
