package baek.silver;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;

public class B10845_큐 {

	public static void main(String args[]) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int N = Integer.parseInt(br.readLine());

		Queue<Integer> queue = new LinkedList<>();
		int back = -1;

		for (int i = 0; i < N; i++) {
			String input = br.readLine();

			switch (input.split(" ")[0]) {
				case "push":
					back = Integer.parseInt(input.split(" ")[1]);
					queue.offer(back);
					break;
				case "pop":
					if (queue.isEmpty()) {
						bw.write("-1" + "\n");
						break;
					}
					bw.write(queue.poll() + "\n");
					break;
				case "size":
					bw.write(queue.size() + "\n");
					break;
				case "empty":
					if (queue.isEmpty()) {
						bw.write("1" + "\n");
					} else {
						bw.write("0" + "\n");
					}
					break;
				case "front":
					if (queue.isEmpty()) {
						bw.write("-1" + "\n");
					} else {
						bw.write(queue.peek() + "\n");
					}
					break;
				case "back":
					if (queue.isEmpty()) {
						bw.write("-1" + "\n");
					} else {
						bw.write(back + "\n");
					}
					break;
			}
		}
		bw.flush();
		bw.close();
	}
}
