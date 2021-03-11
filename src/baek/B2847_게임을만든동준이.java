package baek;

import java.util.Scanner;

public class B2847_게임을만든동준이 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int arr[] = new int[N];
        int ans = 0;

        for(int i = 0; i < N; i++){
            arr[i] = sc.nextInt();
        }

        // N-2부터 시작해서 (N-1번째 데이터는 마지막이니깐 고정값이라 생각)
        // 현재(i) 인덱스와 다음(i+1) 인덱스 비교하여
        // 현재 인덱스의 값이 같거나 크다면,
        // 감소해야하는 수 계산
        for(int i = N-2; i >= 0; i--){
            if(arr[i] >= arr[i+1]){
                int tmp = arr[i] - arr[i+1] + 1;
                ans += tmp;
                arr[i] -= tmp;
            }
        }
        System.out.println(ans);
    }
}
