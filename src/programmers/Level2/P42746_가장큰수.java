package programmers.Level2;

public class P42746_가장큰수 {

	static int[] select;
	static boolean[] visit;
	static int maxValue;

	public static void main(String[] args) {
		int[] numbers = {6, 10, 2};
		int[] numbers2 = {3, 30, 34, 5, 9};

		System.out.println(solution(numbers));
		System.out.println(solution(numbers2));
	}

	private static String solution(int[] numbers) {
		select = new int[numbers.length];
		visit = new boolean[numbers.length];
		maxValue = 0;

		permutation(0, numbers);

		return String.valueOf(maxValue);
	}

	private static void permutation(int k, int[] numbers) {
		if (k == select.length) {
			String tmp = "";
			for (int i : select) {
				tmp += String.valueOf(i);
			}
			maxValue = Math.max(maxValue, Integer.valueOf(tmp));
			return;
		}

		for (int i = 0; i < numbers.length; i++) {
			if (!visit[i]) {
				visit[i] = true;
				select[k] = numbers[i];
				permutation(k + 1, numbers);
				visit[i] = false;
			}
		}
	}

}
