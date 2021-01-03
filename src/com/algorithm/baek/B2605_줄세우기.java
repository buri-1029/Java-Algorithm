package com.algorithm.baek;

import java.util.ArrayList;
import java.util.Scanner;

public class B2605_줄세우기 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt(); // 학생 수 입력
		
		// 줄을 선 순서 저장하는 list 
		ArrayList<Integer> line = new ArrayList<>();

		for (int i = 1; i <= n; i++) {
			int stu = sc.nextInt(); 	// 학생들이 뽑은 번호 입력
			if (i == 1 && stu == 0) { 	// 첫번째 학생은 무조건 0번 번호를 받음
				line.add(i);
			} else {
				// 리스트의 전체 사이즈에서 학생이 뽑은 번호를 뺀 만큼의
				// 인덱스에 현재 학생 번호 추가
				line.add(line.size() - stu, i);
			}
		}
		
		// 최종적으로 줄을 선 순서 출력 
		for (int i = 0; i < line.size(); i++) {
			System.out.print(line.get(i) + " ");
		}
	}
}
