package codility;

public class BinaryGap_Iterations {

	public static void main(String[] args) {
		int N = 1041;
		System.out.println(solution(N));
	}

	private static int solution(int N) {
		String binaryNum = Integer.toBinaryString(N); // 10000010001
		int index = binaryNum.indexOf("1");

		int count = 0;
		int max = 0;

		for (int i = index + 1; i < binaryNum.length(); i++) {
			if (binaryNum.charAt(i) == '0') {
				count++;
			} else {
				max = Math.max(max, count);
				count = 0;
			}
		}

		return max;
	}

}
