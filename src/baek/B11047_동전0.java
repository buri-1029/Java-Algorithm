package baek;

import java.util.Scanner;

public class B11047_동전0 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int K = sc.nextInt();

        int[] coin = new int[N];
        // 가치가 큰 값부터 비교하기 위하여 역으로 저장
        for(int i = N-1; i >=0 ; i--){
            coin[i] = sc.nextInt();
        }

        int cnt = 0;
        for(int i = 0; i < N; i++){
            if(coin[i] > K) continue;
            cnt += K / coin[i];
            K = K % coin[i];
        }
        System.out.println(cnt);
    }
}
