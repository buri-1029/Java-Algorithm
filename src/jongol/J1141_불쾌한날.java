package jongol;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class J1141_불쾌한날 {

	public static void main(String[] args) throws NumberFormatException, IOException {
//		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//		int N = Integer.parseInt(br.readLine());
//		int[] arr = new int[N];
//		
//		for(int i = 0; i < N; i++) {
//			arr[i] = Integer.parseInt(br.readLine());
//		}
//		
//		int ans = 0;
//		for(int i = 0; i < N - 1; i++) {
//			int cnt = 0;
//			for(int j = i + 1; j < N; j++) {
//				if(arr[i] > arr[j]) cnt++;
//				else break;
//			}
//			ans += cnt;
//		}
//		System.out.println(ans);

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		Stack<Integer> stack = new Stack<>();

		long ans = 0;
		for (int i = 0; i < N; i++) {
			int tmp = Integer.parseInt(br.readLine());
			while (!stack.isEmpty() && stack.peek() <= tmp)
				stack.pop();
			ans += stack.size();
			stack.add(tmp);
		}
		System.out.println(ans);
	}
}
