package baek.silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class B10825_국영수 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int N = Integer.parseInt(br.readLine());

		ArrayList<Student> list = new ArrayList<>();
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			list.add(new Student(st.nextToken(), Integer.parseInt(st.nextToken()),
								 Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())
			));
		}

		Collections.sort(list);

		StringBuilder sb = new StringBuilder();
		for (Student student : list) {
			sb.append(student.name)
			  .append('\n');
		}

		System.out.println(sb);
	}

	static class Student implements Comparable<Student> {

		String name;
		int kor;
		int eng;
		int math;

		public Student(String name, int kor, int eng, int math) {
			this.name = name;
			this.kor = kor;
			this.eng = eng;
			this.math = math;
		}

		@Override
		public int compareTo(Student o) {
			if (this.kor == o.kor) {
				if (this.eng == o.eng) {
					if (this.math == o.math) {
						return this.name.compareTo(o.name);
					}
					return o.math - this.math;
				}
				return this.eng - o.eng;
			}
			return o.kor - this.kor;
		}
	}
}
