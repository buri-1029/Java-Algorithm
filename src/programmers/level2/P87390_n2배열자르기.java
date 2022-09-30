package programmers.level2;

import java.util.ArrayList;
import java.util.List;

public class P87390_n2배열자르기 {

	public static void main(String[] args) {
		int n = 3;
		int left = 2;
		int right = 5;

		solution(n, left, right);

	}

	public static List<Long> solution(int n, long left, long right) {

		List<Long> list = new ArrayList<>();

		for (long i = left; i < right + 1; i++) {
			list.add(Math.max(i / n, i % n) + 1); // 몫, 나머지 중 큰 값 + 1
		}

		return list;
	}

}
