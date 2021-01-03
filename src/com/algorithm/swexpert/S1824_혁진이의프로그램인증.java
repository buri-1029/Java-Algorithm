package com.algorithm.swexpert;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
 
public class S1824_혁진이의프로그램인증 {
    static int R, C;
    static String RES = "NO";
    static char[][] board;
    static boolean[][][][] visit;
    static int[] dr = { 0, 0, 1, -1 }; // 오 왼 아래 위
    static int[] dc = { 1, -1, 0, 0 };
    static class Hyuk{
        int r, c, m, d;
 
        public Hyuk(int r, int c, int m, int d) {
            super();
            this.r = r;
            this.c = c;
            this.m = m;
            this.d = d;
        }
         
    }
    public static void main(String[] args) {
        // TODO Auto-generated method stub
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
 
        for (int tc = 1; tc <= T; tc++) {
            R = sc.nextInt();
            C = sc.nextInt();
            board = new char[R][C];
            visit = new boolean[R][C][16][4];
            RES = "NO";
             
            for (int i = 0; i < R; i++) {
                String str = sc.next();
                for (int j = 0; j < C; j++) {
                    board[i][j] = str.charAt(j);
                }
            }
            bfs();
            System.out.println("#"+tc+" "+RES);
        }
    }
 
    private static void bfs() {
        Queue<Hyuk> queue = new LinkedList<>();
        queue.add(new Hyuk(0,0,0,0));   
        visit[0][0][0][0] = true;
         
        while(!queue.isEmpty()) {
            Hyuk H = queue.poll();
            boolean flag = false;
             
            if(board[H.r][H.c]-'0' >= 0 && board[H.r][H.c]-'0' <= 9) {
                H.m = board[H.r][H.c]-'0';
            }else {
                switch(board[H.r][H.c]) {
                case '>' : H.d = 0; break;
                case '<' : H.d = 1; break;
                case 'v' : H.d = 2; break;
                case '^' : H.d = 3; break;
                case '_' : H.d = (H.m == 0 ? 0 : 1); break;
                case '|' : H.d = (H.m == 0 ? 2 : 3); break;
                case '@' : RES = "YES"; return;
                case '+' :
                            if(H.m == 15) H.m = 0;
                            else H.m += 1; 
                            break;
                case '-' : 
                            if(H.m == 0) H.m = 15;
                            else H.m -= 1;
                            break;
                case '?' :  
                            // 모든 방향 다해보기
                            flag = true;
                }
            }
             
            if(flag) {
                for(int d = 0; d < 4; d++) {
                    int nr = H.r + dr[d];
                    int nc = H.c + dc[d];
                    int nd = d;
                     
                    // 범위 벗어나면 반대편 위치로 이동하기
                    if(nr == -1) nr = R - 1;
                    else if(nr == R) nr = 0;
                    if(nc == -1) nc = C - 1;
                    else if(nc == C) nc = 0;
                     
                    if(!visit[nr][nc][H.m][nd]) {
                        queue.add(new Hyuk(nr,nc,H.m,nd));
                        visit[nr][nc][H.m][nd] = true;
                    }
                }
            }else {
                int nr = H.r + dr[H.d];
                int nc = H.c + dc[H.d];
                 
                // 범위 벗어나면 반대편 위치로 이동하기
                if(nr == -1) nr = R - 1;
                else if(nr == R) nr = 0;
                if(nc == -1) nc = C - 1;
                else if(nc == C) nc = 0;
                 
                if(!visit[nr][nc][H.m][H.d]) {
                    queue.add(new Hyuk(nr,nc,H.m,H.d));
                    visit[nr][nc][H.m][H.d] = true;
                }
            }
        }
    }
}