package baek.silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class B1920_수찾기 {

	public static int[] arr;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		arr = new int[N];

		StringTokenizer st = new StringTokenizer(br.readLine(), " ");

		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		Arrays.sort(arr);

		int M = Integer.parseInt(br.readLine());
		st = new StringTokenizer(br.readLine(), " ");
		StringBuilder sb = new StringBuilder();

		for (int i = 0; i < M; i++) {

			// Arrays 클래스의 binarySearch 메소드
			// if (Arrays.binarySearch(arr, Integer.parseInt(st.nextToken())) >= 0) {
			if (binarySearch(Integer.parseInt(st.nextToken())) >= 0) {
				sb.append(1)
				  .append('\n');
			} else {
				sb.append(0)
				  .append('\n');
			}
		}
		System.out.println(sb);
	}

	public static int binarySearch(int key) {
		int left = 0; // 탐색 범위의 왼쪽 끝 인덱스
		int right = arr.length - 1; // 탐색 범위의 오른쪽 끝 인덱스

		// left가 right보다 커지기 전까지 반복한다.
		while (left <= right) {
			int mid = (left + right) / 2;

			if (key < arr[mid]) { // key 값이 중간 위치의 값보다 작을 경우
				right = mid - 1;
			} else if (key > arr[mid]) { // key 값이 중간 위치의 값보다 클 경우
				left = mid + 1;
			} else { // key 값과 중간 위치의 값이 같을 경우
				return mid;
			}
		}
		// 찾고자 하는 값이 존재하지 않을 경우
		return -1;
	}

}
