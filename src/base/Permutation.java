package base;

import java.util.Arrays;
import java.util.Scanner;

public class Permutation {
    static int N, M; // N : 전체 데이터 개수, M : 선택해야 되는 수의 개수
    static int[] input, select; // input : N개의 데이터가 들어갈 배열, select : R개의 선택된 데이터가 들어갈 배열
    static boolean[] visit;

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        M = sc.nextInt();

        input = new int[N];
        select = new int[M];
        visit = new boolean[N];

        // 전체 데이터 준비
        for (int i = 0; i < N; i++) {
            input[i] = i;
        }

        // 순열 만들러 가기
        permutation(0); // 0 : 선택한 데이터 개수
    }

    private static void permutation(int k) {
        // 기저조건(종료조건)
        if (k == select.length) { // 다 뽑은경우
            System.out.println(Arrays.toString(select));
            return;
        }

        /** 순열 **/
        for (int i = 0; i < input.length; i++) {
            if (!visit[i]) {
                visit[i] = true;
                select[k] = input[i];
                permutation(k + 1);
                visit[i] = false;
            }
        }

        /** 중복순열 **/
        for (int i = 0; i < input.length; i++) {
            select[k] = input[i];
            permutation(k + 1);
        }
    }
}