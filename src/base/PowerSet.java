package base;

import java.util.Scanner;

public class PowerSet {
    /** PowerSet(부분집합) */
    static int[] input;
    static boolean[] select;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();

        input = new int[N];
        select = new boolean[N];

        for(int i=0;i<N;i++) {
            input[i] = sc.nextInt();
        }

        powerSet(0,0);
    }

    private static void powerSet(int idx, int k) {
        if(idx == input.length) {
            //if(k==3) { // k : 자릿수 (1개인, 2개인 ,3개인...)
            for(int i=0;i<input.length;i++) {
                System.out.print(select[i] ? input[i]+" " : "");
            }
            System.out.println();
            //}
            return;
        }
        select[idx] = true;
        powerSet(idx+1,k+1);

        select[idx] = false;
        powerSet(idx+1,k);
    }
}