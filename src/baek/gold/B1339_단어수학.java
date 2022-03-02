package baek.gold;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

/**
 * ! N개의 단어가 주어졌을 때, 그 수의 합을 최댓값 구하기
 */
public class B1339_단어수학 {

	static int N, max = 0;
	static String[] arr;    // 입력받은 문자열 저장할 배열
	static int[] alpa;        // 숫자를 선택할 배열
	static int[] num = {0, 1, 2, 3, 4, 5, 6, 7, 8, 9};
	static List<Integer> list = new ArrayList<>(); // 각 알파벳을 저장할 리스트
	static boolean[] v = new boolean[10];

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		arr = new String[N];

		for (int i = 0; i < N; i++) {
			arr[i] = br.readLine();
			for (int j = 0; j < arr[i].length(); j++) {
				if (!list.contains(arr[i].charAt(j) - 'A')) {
					list.add(arr[i].charAt(j) - 'A');
				} // 문자열에 포함된 알파벳이 리스트에 포함되어 있지않으면 현재 알파벳 추가
			}
		}

		// 리스트의 크기만큼 배열 크기 생성
		alpa = new int[list.size()];

		permutation(0);
		System.out.println(max);
	}

	private static void permutation(int k) {
		// TODO Auto-generated method stub
		if (k == list.size()) {
			int sum = 0;
			for (int i = 0; i < N; i++) { // 입력받은 문자열 개수 만큼 ex) 2 개
				int num = 0;              // 1. GCF 2. ACDEB
				for (int j = 0; j < arr[i].length(); j++) {
					num *= 10;              // ex) G는 3번 돌면서 100의 자리가 됨
					num += alpa[list.indexOf(arr[i].charAt(j) - 'A')];
				}
				sum += num;
			}
			max = Math.max(max, sum);
			return;
		}

		// 0 ~ 9 까지 N개의 알파벳에 숫자 배정
		for (int i = 0; i < num.length; i++) {
			if (v[i] != true) {
				v[i] = true;
				alpa[k] = num[i];
				permutation(k + 1);
				v[i] = false;
			}
		}
	}
}