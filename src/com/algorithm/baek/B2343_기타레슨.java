package com.algorithm.baek;

import java.util.Scanner;

public class B2343_기타레슨 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int M = sc.nextInt();

		int[] arr = new int[N];

		int left = -1, right = 0;

		for (int i = 0; i < N; i++) {
			arr[i] = sc.nextInt();
			right += arr[i]; 
			// 제일 끝 값 = 모든 레슨의 길이 더한 값
			left = Math.max(left, arr[i]); 
			// 왼쪽 끝 값 = 레즌 중 가장 크기가 큰 값
		}

		while (left <= right) {
			int mid = (left + right) / 2; // 임의로 가정한 블루레이의 크기
			int sum = 0, cnt = 0;

			for (int i = 0; i < N; i++) {
				if (sum + arr[i] > mid) {
					sum = 0;
					cnt++;
				}
				sum += arr[i];
			}
			if (sum != 0) cnt++;
			if (cnt <= M) right = mid - 1;
			else left = mid + 1;
		}
		System.out.println(left);
	}

}
