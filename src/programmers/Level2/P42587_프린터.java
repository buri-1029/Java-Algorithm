package programmers.Level2;

import java.util.ArrayList;

public class P42587_프린터 {

	public static void main(String[] args) {
		int[] priorities = {2, 1, 3, 2};
		int location = 2;

		int[] priorities2 = {1, 1, 9, 1, 1, 1};
		int location2 = 0;

		System.out.println(solution(priorities, location));
		System.out.println(solution(priorities2, location2));
	}

	private static int solution(int[] priorities, int location) {
		ArrayList<Docu> arr = new ArrayList<>();
		ArrayList<Integer> ans = new ArrayList<>();

		for (int i = 0; i < priorities.length; i++) {
			arr.add(new Docu(priorities[i], i));
		}

		while (!arr.isEmpty()) {
			Docu docu = arr.get(0);
			arr.remove(docu);

			boolean flag = true;
			for (int i = 0; i < arr.size(); i++) {
				if (docu.priority < arr.get(i).priority) {
					arr.add(docu);
					flag = false;
					break;
				}
			}

			if (flag) {
				ans.add(docu.location);
			}

		}

		return ans.indexOf(location) + 1;
	}

	public static class Docu {

		int priority;
		int location;

		public Docu(int priority, int location) {
			this.priority = priority;
			this.location = location;
		}
	}

}
