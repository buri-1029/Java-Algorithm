package programmers.level1;

public class P82612_부족한금액계산하기 {

	public static void main(String[] args) {
		int price = 3;
		int money = 20;
		int count = 4;

		long result = solution(price, money, count);
		System.out.println(result);
	}

	private static long solution(int price, int money, int count) {
		int N = 0;
		long needMoney = 0;
		while (count != N) {
			needMoney += (price * ++N);
		}
		long answer = (needMoney - money) <= 0 ? 0 : (needMoney - money);
		return answer;
	}
}
