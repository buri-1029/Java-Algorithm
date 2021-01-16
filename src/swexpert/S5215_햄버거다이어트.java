package swexpert;

import java.util.Scanner;

public class S5215_햄버거다이어트 {
	static int[] score;
    static int[] calorie;
    static int MAX ,N, L;
    public static void main(String[] args) {
        // TODO Auto-generated method stub
        Scanner sc = new Scanner(System.in);
         
        int T = sc.nextInt();
        for(int tc=1;tc<=T;tc++) {
            MAX = 0;
            N = sc.nextInt();
            L = sc.nextInt();
            score = new int[N];
            calorie = new int[N];
             
            for(int n=0;n<N;n++) {
                score[n] = sc.nextInt();
                calorie[n] = sc.nextInt();
            }
             
            select_hamburger(0,0,new boolean[calorie.length]);
            System.out.println("#"+tc+" "+MAX);
        }
    }
    private static void select_hamburger(int idx, int k, boolean[] sel) {
        // TODO Auto-generated method stub
        int SUM1 = 0, SUM2=0;
        if(idx == calorie.length) {
            for(int i=0;i<calorie.length;i++) {
                if(sel[i] == true) {
                    if((SUM1+calorie[i]) > L) {
                        continue;
                    }else {
                        SUM1+=calorie[i];
                        SUM2+=score[i];
                        if(MAX<SUM2) {
                            MAX = SUM2;
                        }
                    }
                }
            }
            return;
        }
        sel[idx] = true;
        select_hamburger(idx+1,k+1,sel);
        sel[idx] = false;
        select_hamburger(idx+1,k,sel);
    }
}
