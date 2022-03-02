package baek.silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/* 다시 풀어보기 */
public class B9724_순열 {

	private static int N, order, total;
	private static boolean[] isSelected;
	private static char[] input, p;

	public static void main(String[] args) throws NumberFormatException, IOException {

		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		String line = null, data;

		while ((line = in.readLine()) != null) {
			StringTokenizer st = new StringTokenizer(line); // abc 4
			data = st.nextToken();
			input = data.toCharArray(); // 입력데이터
			order = Integer.parseInt(st.nextToken()); // 원하는 순열의순서
			N = input.length; // 원소의 크기
			p = new char[N]; // 순열처리한 결과
			isSelected = new boolean[N];// 선택된 원소를 기억할 배열
			total = 0; // 순열처리횟수

			int fac = 1, i = N;
			while (i > 0) {
				fac *= i;
				--i;
			} // n자리수 순열의 경우의 수 계산

			if (order > fac) { // 순열 불가
				System.out.println(data + " " + order + " = No permutation");
			} else { // 순열 가능
				System.out.print(data + " " + order + " = ");
				permutation(0);
				System.out.println();
			}

		}
	}

	private static boolean permutation(int cnt) {

		if (cnt == N) {
			total++; // 순열 처리횟수 증가
			if (total == order) { // 문제에서 요구하는 답
				for (int i = 0; i < N; i++) {
					System.out.print(p[i]);
				}
				return true;
			}
			return false; // 현순열은 요구하는 순열의 순서가 아직 되지 않았다.
		}

		for (int i = 0; i < N; i++) {
			if (isSelected[i]) {
				continue; // 앞쪽에서 순열에 사용된 수
			}

			p[cnt] = input[i]; // 순열 위치에 저장
			isSelected[i] = true; // 해당 원소 선택 처리
			if (permutation(cnt + 1) == true) {
				return true;
			}
			isSelected[i] = false;
		}
		return false;
	}

}