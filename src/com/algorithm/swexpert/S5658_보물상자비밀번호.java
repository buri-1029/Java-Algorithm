package com.algorithm.swexpert;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.StringTokenizer;
import java.util.TreeSet;

/*
 *  다시 풀어보기
 */
public class S5658_보물상자비밀번호 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(in.readLine());
		
		for(int t = 1; t <= T; t++) {
			StringTokenizer st = new StringTokenizer(in.readLine()," ");
			int N = Integer.parseInt(st.nextToken()); // N: 8 - 28
			int C = N/4; // 한변의 길이 : 2-7 ==> 회전횟수 결정 
			int K = Integer.parseInt(st.nextToken());
			char[] nums = in.readLine().toCharArray();
			// String nums = in.readLine();
			// nums.concat(nums); // shift 처리하지 않기 위해 자신의 문자열을 한번 붙임.
			
			TreeSet<String> set = new TreeSet<String>(new Comparator<String>() {

				@Override
				public int compare(String o1, String o2) {
					// TODO Auto-generated method stub
					return o2.compareTo(o1); // 정수일때: o2 - o1
				}
			});
			
			int c = 0;
			while(++c < C) { // 회전관련 처리 C번
				// 현상태에서 각 변의 길이만큼의 문자열 비밀번호 추출하여 set에 넣기
				for(int i = 0; i < N; i+=C) {
					String s = "";
					for(int j = 0; j < C; j++) {
						s += nums[i + j];
					}
					set.add(s);
				}
				
				// 시계방향으로 하나 shift
				char temp = nums[N-1];
				for(int i = N-1; i > 0; i--) {
					nums[i] = nums[i - 1];
				}
				nums[0] = temp;
				
			}
			
			int k = 0, ans = 0;
			for(String s : set) {
				if(++k == K ) {
					ans = Integer.parseInt(s, 16);
					break;
				}
			}
			System.out.println("#" + t + " " + ans);
		}
	}

}
