package baek.silver;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.Scanner;

public class B15651_NandM3 {

	/**
	 * 1부터 N까지 자연수 중에서 M개를 고른 수열(중복 o)
	 */
	static int N, M;
	static int[] arr;
	static int[] sel;
	static BufferedWriter br;

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		br = new BufferedWriter(new OutputStreamWriter(System.out));
		N = Integer.parseInt(sc.next());
		M = Integer.parseInt(sc.next());

		arr = new int[N];
		sel = new int[M];

		for (int i = 0; i < N; i++) {
			arr[i] = i + 1;
		}

		recursive(0);
		br.flush();
	}

	private static void recursive(int k) throws IOException {
		if (k == M) { // M개 만큼 뽑았다면 sel출력
			for (int i = 0; i < M; i++) {
				br.write(sel[i] + " ");
			}
			br.write("\n");
			return;
		}

		for (int i = 0; i < arr.length; i++) {
			sel[k] = arr[i]; // 뽑은 원소를 sel배열에 저장
			recursive(k + 1);
		}
	}
}