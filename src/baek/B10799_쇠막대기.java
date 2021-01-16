package baek;

import java.util.Scanner;
import java.util.Stack;

public class B10799_쇠막대기 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc= new Scanner(System.in);
		String str = sc.next();
		Stack<String> stack = new Stack<>();
		
		int cnt = 0;
		
		str = str.replace("()", "*");
		
		for(int i=0;i<str.length();i++) {
			if(str.charAt(i)=='*') {
				cnt+=stack.size();
			}else if(str.charAt(i)==')') {
				stack.pop();
				cnt+=1;
			}else {
				stack.push("(");
			}
		}
		System.out.println(cnt);
	}
}
