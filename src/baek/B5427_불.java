package baek;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class B5427_불 {
    static int w, h, ans;
    static boolean isPossible;
    static char[][] map;
    static boolean[][] visit;
    static Queue<Point> queue;
    static Queue<Point> fire_queue;
    static int[] dr = {0, 0, 1, -1};
    static int[] dc = {1, -1, 0, 0};
    static class Point{
        int r, c;

        public Point(int r, int c) {
            super();
            this.r = r;
            this.c = c;
        }
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();

        for(int tc = 0;tc < T; tc++){
            w = sc.nextInt();
            h = sc.nextInt();
            map = new char[h][w];
            visit = new boolean[h][w];

            queue = new LinkedList<>();
            fire_queue = new LinkedList<>();
            isPossible = false;
            ans = 0;

            for(int i = 0; i < h; i++) {
                String str = sc.next();
                for(int j = 0; j < w; j++) {
                    map[i][j] = str.charAt(j);
                    if(map[i][j] == '*') {
                        fire_queue.add(new Point(i, j));
                    }else if(map[i][j] == '@') {
                        queue.add(new Point(i, j));
                        visit[i][j] = true;
                    }
                }
            }
            bfs();
            if(!isPossible)
                System.out.println("IMPOSSIBLE");
        }
    }

    private static void bfs() {

        while(!queue.isEmpty()) {
            int fire_len = fire_queue.size();
            for(int i = 0; i < fire_len; i++){
                Point p = fire_queue.poll();

                for(int d = 0; d < 4; d++) {
                    int nr = p.r + dr[d];
                    int nc = p.c + dc[d];

                    if(nr < 0 || nr >= h || nc < 0 || nc >= w || map[nr][nc] == '#') continue;

                    if(map[nr][nc] == '.') {
                        map[nr][nc] = '*';
                        fire_queue.add(new Point(nr, nc));
                    }
                }
            }

            int len = queue.size();
            for(int i = 0; i < len; i++){
                Point p = queue.poll();

                if(p.r == 0 || p.c == 0 || p.r == h - 1 || p.c == w - 1){
                    System.out.println(ans + 1);
                    isPossible = true;
                    return;
                }

                for(int d = 0; d < 4; d++) {
                    int nr = p.r + dr[d];
                    int nc = p.c + dc[d];

                    if(map[nr][nc] == '#'|| map[nr][nc] == '*') continue;

                    if(map[nr][nc] == '.' && !visit[nr][nc]) {
                        map[p.r][p.c] = '.';
                        map[nr][nc] = '@';
                        visit[nr][nc] = true;
                        queue.add(new Point(nr, nc));
                    }
                }
            }
            ans++;
        }
    }
}
