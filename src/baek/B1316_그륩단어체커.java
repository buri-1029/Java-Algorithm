package baek;

import java.util.Scanner;
/*
 * 백준 - 구현
 * 
 */
public class B1316_그륩단어체커 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int cnt = 0;
		
		for(int i = 0; i < n; i++) {
			boolean[] alpha = new boolean[26]; 
			String str = sc.next();
			char before = str.charAt(0);
			alpha[str.charAt(0) - 'a'] = true;
			
			for(int j = 1; j < str.length(); j++) {
				if(alpha[str.charAt(j) - 'a'] == false) {
					alpha[str.charAt(j) - 'a'] = true;
					before = str.charAt(j);
				}else if(alpha[str.charAt(j) - 'a'] == true && before != str.charAt(j))	{
					cnt++;
					break;
				}
			}
		}
		System.out.println(n - cnt);
	}
}
