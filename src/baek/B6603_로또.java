package baek;

import java.util.Scanner;
/* 조합 */
public class B6603_로또 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        while(true){
            int k = sc.nextInt();
            if(k == 0) break;

            int[] S = new int[k];
            int[] L = new int[6];
            for(int i = 0; i < k; i++){
                S[i] = sc.nextInt();
            }
            lotto(S, L, 0, 0);
            System.out.println();
        }
    }

    private static void lotto(int[] s, int[] l, int idx, int cnt) {
        if(cnt == l.length){
            for(int i = 0; i < l.length; i++){
                System.out.print(l[i] + " ");
            }
            System.out.println();
            return;
        }

        for(int i = idx; i < s.length; i++){
            l[cnt] = s[i];
            lotto(s, l, i + 1, cnt + 1);
        }
    }
}
