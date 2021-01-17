package baek;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
/*
    비슷한 문제 : 1387 양치기꿍 - dfs
               3184 양     - bfs
 */
public class B3184_양 {
    static int R, C, ocnt, vcnt, oAns = 0, vAns = 0;
    static char[][] map;
    static boolean[][] visit;
    static int[] dr = { -1, 1, 0, 0 };
    static int[] dc = { 0, 0, -1, 1 };
    static class Point {
        int r;
        int c;
        public Point(int r, int c){
            this.r = r;
            this.c = c;
        }
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        R = sc.nextInt();
        C = sc.nextInt();
        map = new char[R][C];
        visit = new boolean[R][C];

        for(int i = 0; i < R; i++) {
            String str = sc.next();
            for(int j = 0; j < C; j++) {
                map[i][j] = str.charAt(j);
            }
        } // 마당 입력 완료

        for(int i = 0; i < R; i++){
            for(int j = 0; j < C; j++){
                if(map[i][j] != '#' && !visit[i][j]){
                    ocnt = 0; // 양의 수
                    vcnt = 0; // 늑대의 수
                    bfs(i,j);
                    if(ocnt > vcnt) vcnt = 0; // 양 > 늑대 : 늑대 = 0
                    else ocnt = 0; // 그렇지않으면 양 = 0
                    oAns += ocnt; 
                    vAns += vcnt;
                }
            }
        }
        System.out.println(oAns+" "+vAns);
    }

    private static void bfs(int i, int j) {
        Queue<Point> queue = new LinkedList<>();
        queue.add(new Point(i, j));
        visit[i][j] = true;

        while(!queue.isEmpty()){
            Point p = queue.poll();

            if(map[p.r][p.c] == 'o') ocnt++;
            else if(map[p.r][p.c] == 'v') vcnt++;

            for(int d = 0; d < 4; d++){
                int nr = p.r + dr[d];
                int nc = p.c + dc[d];

                if(nr < 0 || nc < 0 || nr >= R || nc >= C
                        || visit[nr][nc] || map[nr][nc] == '#') continue;

                visit[nr][nc] = true;
                queue.add(new Point(nr, nc));
            }
        }
    }
}
