package com.algorithm.baek;

import java.util.Scanner;

public class B2941_크로아티아 {
	/** */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String[] alpa = {"c=","c-","dz=","d-","lj","nj","s=","z="};
		Scanner sc = new Scanner(System.in);
		String str= sc.next();

		for(int i=0;i<alpa.length;i++) {
			if(str.contains(alpa[i])) { //alpa에 있는 문자가 포함되어있다면,
				str = str.replaceAll(alpa[i],"*"); //그 문자 모두 *로 치환
			}
		}
		System.out.println(str.length()); //읿반 문자와 alpa문자를 치환한 *으로 										  //이루어진 문자열의 길이 구하면 끝!
	}
}
