package baek.silver;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Stack;

public class B10828_스택 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		Stack<Integer> stack = new Stack<>();

		int num = Integer.parseInt(br.readLine());

		for (int i = 0; i < num; i++) {
			String[] input = br.readLine()
							   .split(" ");

			switch (input[0]) {
				case "push":
					stack.push(Integer.parseInt(input[1]));
					break;
				case "pop":
					if (stack.empty()) {
						bw.write("-1" + "\n");
					} else {
						bw.write(stack.pop() + "\n");
					}
					break;
				case "size":
					bw.write(stack.size() + "\n");
					break;
				case "empty":
					if (stack.empty()) {
						bw.write("1" + "\n");
					} else {
						bw.write("0" + "\n");
					}
					break;
				case "top":
					if (stack.empty()) {
						bw.write("-1" + "\n");
					} else {
						bw.write(stack.peek() + "\n");
					}
					break;
			}

		}
		bw.flush();
		bw.close();
	}
}
