package baek;

import java.util.Arrays;
import java.util.Scanner;

public class B1931_회의실배정 {

	static class Room implements Comparable<Room> {
		int start, end;

		public Room(int start, int end) {
			super();
			this.start = start;
			this.end = end;
		}

		public int compareTo(Room o) {
			int time = this.end - o.end;
			// 종료시간이 틀리면
			if (time != 0) {
				return time;
			} // 종료시간이 같으면 시작시간이 빠른 순
			return this.start - o.start;
		}
	}


	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		Room[] arr = new Room[N];

		for (int i = 0; i < N; i++) {
			arr[i] = new Room(sc.nextInt(), sc.nextInt());
		}
		
		Arrays.sort(arr);
		int cnt = 1;
		int end = arr[0].end;

		for (int i = 1; i < N; i++) {
			if(arr[i].start >= end) {
				cnt++;
				end = arr[i].end;
			}
		}
		System.out.println(cnt);
	}
}
