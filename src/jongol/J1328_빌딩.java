package jongol;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;

public class J1328_빌딩 {
	static class Point{
		int h, idx;
		
		public Point(int h, int idx) {
			super();
			this.h = h;
			this.idx = idx;
		}
	}
	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		Stack<Point> stack = new Stack<>();
		int[] ans = new int[N + 1];

		for (int i = 1; i <=N; i++) {
			int H = Integer.parseInt(br.readLine());
			while (!stack.isEmpty() && stack.peek().h < H) {
				ans[stack.peek().idx] = i;
				stack.pop();
			}	
			stack.add(new Point(H,i));
		}
		
		for(int i = 1; i <= N; i++) {
			System.out.println(ans[i]);
		}
	}
}
