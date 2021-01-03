package com.algorithm.baek;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class B1194_달이차오른다가자 {
    static int N, M, RES = -1;
    static char[][] map;
    static boolean[][][] visit;

    static int[] dr = { 0, 0, 1, -1 };
    static int[] dc = { 1, -1, 0, 0 };

static class Point {
    int r, c, cnt, key;

    public Point(int r, int c, int cnt, int key) {
        super();
        this.r = r;
        this.c = c;
        this.cnt = cnt;
        this.key = key;
    }

}

public static void main(String[] args) {
    // TODO Auto-generated method stub
    Scanner sc = new Scanner(System.in);
    N = sc.nextInt();
    M = sc.nextInt();
    map = new char[N][M];
    visit = new boolean[N][M][1<<6];
    
    int st_r = 0, st_c = 0;
    for (int i = 0; i < N; i++) {
        String str = sc.next();
        for (int j = 0; j < M; j++) {
            map[i][j] = str.charAt(j);
            if (map[i][j] == '0') { // 시작점 알아놓기
                st_r = i;
                st_c = j;
            }
        }
    }
    bfs(st_r, st_c, 0, 0);
    System.out.println(RES);
}

private static void bfs(int r, int c, int cnt, int key) {
    // TODO Auto-generated method stub
    Queue<Point> queue = new LinkedList<>();
    queue.add(new Point(r, c, cnt, key));
    visit[r][c][0] = true;
    int CNT = 0;
    
    while (!queue.isEmpty()) {
        Point p = queue.poll();

        if (map[p.r][p.c] == '1') {
            RES = p.cnt;
            break;
        }
        for (int d = 0; d < 4; d++) {
            int nr = p.r + dr[d];
            int nc = p.c + dc[d];
            int k = p.key;
            
            if(nr < 0 || nc < 0 || nr >= N || nc >= M || map[nr][nc] == '#') continue;
            if (visit[nr][nc][k]) continue; 

            if(map[nr][nc] >= 'a' && map[nr][nc] <= 'f') { // 이동한 칸에 열쇠가 있다면,
                k |= (1 << (map[nr][nc] - 'a')); // 열쇠 추가
            }
            
            if (map[nr][nc] >= 'A' && map[nr][nc] <= 'F') { // 이동한 칸에 문이 있다면,
                if((k & (1 << (map[nr][nc] - 'A'))) == 0) continue; // 문을 열 수 있는 열쇠있나 확인
            }                                                        // 없으면 continue
            
            visit[nr][nc][k] = true;
            queue.add(new Point(nr,nc,p.cnt+1,k));
        }
    }
}
}