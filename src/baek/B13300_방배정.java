package baek;

import java.util.Scanner;

public class B13300_방배정 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt(); // 학생 수
		int K = sc.nextInt(); // 최대 인원 수

		int room = 0; // 최소한의 방의 수

		int[][] stu = new int[2][6]; // 성별과 학년에 따른 학생 수 저장한 배열

		for (int i = 0; i < N; i++) {
			stu[sc.nextInt()][sc.nextInt() - 1]++;
		}

		for (int i = 0; i < 2; i++) {
			for (int j = 0; j < 6; j++) {
				// 학생의 수가 없으면 방 필요없음
				if(stu[i][j] == 0) continue;				

				room += stu[i][j] / K;	// 필요한 방 계산
				
				// 방이 학생의 수에 나누어 떨어지지 않으면 방 하나 더 필요
				if (stu[i][j] % K != 0)  
					room += 1;
			}
		}
		System.out.println(room);
	}
}
