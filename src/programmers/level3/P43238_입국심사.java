package programmers.level3;

import java.util.Arrays;

public class P43238_입국심사 {

	public static void main(String[] args) {
		int n = 6;
		int[] times = {7, 10};

		System.out.println(solution(n, times));
	}

	public static long solution(int n, int[] times) {
		Arrays.sort(times);

		long min = 0;
		long max = n * (long) times[times.length - 1];
		long answer = max;

		while (min <= max) {
			long mid = (min + max) / 2;
			long sum = 0;

			for (int time : times) {
				sum += mid / time;
			}

			if (sum < n) {
				min = mid + 1;
			} else {
				max = mid - 1;
				answer = mid;
			}
		}

		return answer;
	}
}
