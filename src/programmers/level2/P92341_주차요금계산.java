package programmers.level2;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

public class P92341_주차요금계산 {

	public static void main(String[] args) {
		int[] fees = {180, 5000, 10, 600};
		String[] records = {"05:34 5961 IN", "06:00 0000 IN", "06:34 0000 OUT", "07:59 5961 OUT",
			"07:59 0148 IN", "18:59 0000 IN", "19:09 0148 OUT", "22:59 5961 IN", "23:00 5961 OUT"};

		System.out.println(Arrays.toString(solution(fees, records)));
	}

	public static int[] solution(int[] fees, String[] records) {
		Map<String, String> map1 = new HashMap<>();
		Map<String, Integer> map2 = new TreeMap<>();

		for (String record : records) {
			String[] arr = record.split(" ");

			if (arr[2].equals("IN")) {
				map1.put(arr[1], arr[0]);
			} else if (arr[2].equals("OUT")) {
				int time = calculateTime(map1.get(arr[1]), arr[0]);
				map1.remove(arr[1]);
				map2.put(arr[1], map2.containsKey(arr[1]) ? map2.get(arr[1]) + time : time);
			}
		}

		if (map1.size() > 0) {
			for (String carNum : map1.keySet()) {
				int time = calculateTime(map1.get(carNum), "23:59");
				map2.put(carNum, map2.containsKey(carNum) ? map2.get(carNum) + time : time);
			}
		}

		int[] answer = new int[map2.size()];
		calculateFee(fees, map2, answer);

		return answer;
	}

	private static void calculateFee(int[] fees, Map<String, Integer> map2, int[] answer) {
		int idx = 0;

		for (String carNum : map2.keySet()) {

			double tmp = (double) (map2.get(carNum) - fees[0]) / fees[2];

			if (map2.get(carNum) <= fees[0]) {
				answer[idx++] = fees[1];
			} else if (tmp % 10 != 0) {
				answer[idx++] = fees[1] + (int) Math.ceil(tmp) * fees[3];
			} else {
				answer[idx++] = fees[1] + ((map2.get(carNum) - fees[0]) / fees[2]) * fees[3];
			}

		}
	}

	private static int calculateTime(String str, String record) {
		int outHour = Integer.parseInt(record.split(":")[0]);
		int inHour = Integer.parseInt(str.split(":")[0]);

		int outMinute = Integer.parseInt(record.split(":")[1]);
		int inMinute = Integer.parseInt(str.split(":")[1]);

		if (inMinute > outMinute) {
			outHour--;
			outMinute += 60;
		}

		return (outHour - inHour) * 60 + (outMinute - inMinute);
	}
}
