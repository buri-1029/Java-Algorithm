package baek;

import java.util.Scanner;

public class B1748_수이어쓰기1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();

        int ans = 0;
        int cnt = 0;
        int length = 1;
        int disit = 1;
        for(int i = 1; i <= N; i++){
            cnt++;
            ans += length ;
            if(cnt == 9 * disit ) {
                cnt = 0;
                length += 1;
                disit *= 10;
            }
        }
        System.out.println(ans);
    }
}
