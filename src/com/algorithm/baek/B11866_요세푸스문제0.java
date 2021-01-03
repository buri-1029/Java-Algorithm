package com.algorithm.baek;

import java.util.LinkedList;
import java.util.Scanner;

/* 자료구조 - QUEUE 사용 */
public class B11866_요세푸스문제0 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int K = sc.nextInt()-1;

		LinkedList<Integer> people = new LinkedList<>();
		for (int i = 0; i < N; i++)	people.add(i + 1);

		int idx = K;
		System.out.print("<");
		while (people.size() != 1) {
			System.out.print(people.get(idx).toString() + ", ");
			people.remove(idx);
			idx = (idx + K) % people.size();
		}
		System.out.print(people.pop().toString() + ">");
	}

}
