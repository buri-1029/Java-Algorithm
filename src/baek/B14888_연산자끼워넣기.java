package baek;

import java.util.Scanner;

/** 다음에 백트래킹 이용해서 풀어보기 */
public class B14888_연산자끼워넣기 {
	static int N;
	static int[] num;
	static int max = Integer.MIN_VALUE;
	static int min = Integer.MAX_VALUE;

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		num = new int[N]; 
		int[] op = new int[4];

		for (int i = 0; i < N; i++) {
			num[i] = sc.nextInt(); //숫자 배열에 입력
		}

		for (int i = 0; i < op.length; i++) {
			op[i] = sc.nextInt(); //연산자 수 배열에 입력 
		}						 //0: +, 1: -, 2: *, 3: /

		/** *************** */
		calculate(1, num[0], op[0], op[1], op[2], op[3]); //재귀 
		System.out.println(max);
		System.out.println(min);
	}

	private static void calculate(int idx, int sum, int op1, int op2, int op3, int op4) {
		// TODO Auto-generated method stub
		if (idx == N) {
			max = Math.max(max, sum);
			min = Math.min(min, sum);
		}

		if (op1 > 0) { // + 연산 있으면 그 다음 숫자 인덱스+1, sum에도 그만큼 , + 연산 사용했으니 -1,,,
			calculate(idx + 1, sum + num[idx], op1 - 1, op2, op3, op4);
		}
		if (op2 > 0) {
			calculate(idx + 1, sum - num[idx], op1, op2 - 1, op3, op4);
		}
		if (op3 > 0) {
			calculate(idx + 1, sum * num[idx], op1, op2, op3 - 1, op4);
		}
		if (op4 > 0) {
			calculate(idx + 1, sum / num[idx], op1, op2, op3, op4 - 1);
		}
	}
}
