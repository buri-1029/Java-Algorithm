package com.algorithm.swexpert;

import java.util.Scanner;

public class S7272_안경이없어 {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int T = scan.nextInt();
		for (int t = 1; t <= T; t++) {
			String alpa1 = "CEFGHIJKLMNSTUVWXYZ";
			String alpa2 = "ADOPQR";

			String str1 = scan.next();
			String str2 = scan.next();
			boolean res = true;
            
			char[] word1 = str1.toCharArray();
			char[] word2 = str2.toCharArray();
			if (word1.length != word2.length) {
				res = false;
			} else {
				for (int i = 0; i < word1.length; i++) {
					if (alpa1.contains(Character.toString(word1[i])) && alpa1.contains(Character.toString(word2[i]))) {
					} else if (alpa2.contains(Character.toString(word1[i])) && alpa2.contains(Character.toString(word2[i]))) {
					} else if (word1[i] == 'B' && word2[i] == 'B') {
					} else
						res = false;
				}
			}
			System.out.println("#" + t + " " + (res ? "SAME" : "DIFF"));
		}
	}

}
