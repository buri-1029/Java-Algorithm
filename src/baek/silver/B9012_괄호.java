package baek.silver;

import java.util.Scanner;
import java.util.Stack;

/*  스택 기본 문제 */
public class B9012_괄호 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();

		for (int i = 0; i < N; i++) {
			String str = sc.next();
			boolean flag = true;
			Stack<Character> vps = new Stack<>();
			for (int j = 0; j < str.length(); j++) {
				if (str.charAt(j) == ')') {   // ')'
					if (vps.isEmpty()) {      // ')'인데 stack이 비어있다는 소리는
						flag = false;       // '('이 없다는 소리로 짝이 맞지 않다.
						break;
					} else if (vps.peek() == '(') {
                        vps.pop();
                    }
				} else {
					vps.push(str.charAt(j));
				}
			}
            if (vps.size() > 0) {
                flag = false;
            }

            if (flag) {
                System.out.println("YES");
            } else
                System.out.println("NO");
		}
	}
}
