package baek;

import java.util.Scanner;

// 순열을 이용하여 풀었지만, 좀 더 효율적인 방법으로 다시 풀어보기
public class B1138_한줄로서기 {
    static int N;
    static int[] arr, input, select;
    static boolean[] visit;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();

        arr = new int[N];
        for(int i = 0; i < N; i++){
            arr[i] = sc.nextInt();
        }

        input = new int[N];
        select = new int[N];
        visit = new boolean[N];

        // 1부터 N까지 데이터 생성
        for (int i = 0; i < N; i++) {
            input[i] = i + 1;
        }

        // 순열 만들러 가기
        permutation(0); // 0 : 선택한 데이터 개수
    }

    private static void permutation(int k) {
        // 기저조건(종료조건)
        if (k == select.length) { // 다 뽑은경우
            int[] tmp = new int[N];
            tmp[0] = 0;
            // 첫번째는 어차피 0이니 뽑은 배열 중 0이 아닌 것들은 제외,
            if(tmp[0] != arr[select[0] - 1]) return;
            else{
                for(int i = 1; i < N; i++){
                    int cnt = 0;
                    for(int j = 0; j < i; j++){
                        if(select[i] < select[j]){
                            cnt++;
                        }
                    }
                    tmp[i] = cnt;
                    if(tmp[i] != arr[select[i] - 1]) return;
                }
            }
            // System.out.println(Arrays.toString(select));
            for(int i = 0; i < N; i++){
                System.out.print(select[i]+" ");
            }
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
    }
}
