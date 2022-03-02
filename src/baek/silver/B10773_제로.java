package baek.silver;

import java.util.Scanner;
import java.util.Stack;

public class B10773_제로 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int K = sc.nextInt();
		Stack<Integer> stack = new Stack<>();
		for (int i = 0; i < K; i++) {
			int num = sc.nextInt();
            if (num == 0) {
                stack.pop();
            } else {
                stack.push(num);
            }
		}
		int ans = 0;
		while (!stack.isEmpty()) {
			ans += stack.pop();
		}
		System.out.println(ans);
	}
}
