package base;

import java.util.Arrays;
import java.util.Scanner;

public class Combination {
    static int N, M; // N : 전체 데이터 개수, M : 선택해야 되는 수의 개수
    static int[] input, select; // input : N개의 데이터가 들어갈 배열, select : R개의 선택된 데이터가 들어갈 배열

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        M = sc.nextInt();

        input = new int[N];
        select = new int[M];

        // 전체 데이터 준비
        for (int i = 0; i < N; i++) {
            input[i] = i;
        }

        // 조합 만들러 가기
        combination(0, 0); // 0 : 선택 대상이 되는 데이터의 시작 위치, 0 : 선택한 데이터 개수
    }

    private static void combination(int idx, int k) {
        // 기저조건(종료조건)
        if (k == select.length) { // 다 뽑은경우
            System.out.println(Arrays.toString(select));
            return;
        }

        /** 방법1 **/
        if (idx == input.length) {
            return;
        }
        select[k] = input[idx];
        combination(idx + 1, k + 1);
        combination(idx + 1, k);

        /** 방법2 **/
        for (int i = idx; i < input.length; i++) {
            select[k] = input[i]; // 데이터 한 개 선택
            combination(i + 1, k + 1);
        }
        /** 중복조합 **/
        for (int i = idx; i < input.length; i++) {
            select[k] = input[i]; // 데이터 한 개 선택
            combination(i, k + 1);
        }
    }
}
