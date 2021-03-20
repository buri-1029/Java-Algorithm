package baek;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class B1926_그림BFS {
    static int n, m, cnt = 0, area = 0;
    static int[][] arr;
    static boolean[][] visit;
    static int[] dr = {-1, 1, 0, 0};
    static int[] dc = {0, 0, -1, 1};

    static class Point {
        int r, c;

        Point(int r, int c) {
            this.r = r;
            this.c = c;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();

        arr = new int[n][m];
        visit = new boolean[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                arr[i][j] = sc.nextInt();
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (arr[i][j] == 1 && !visit[i][j]) {
                    bfs(i, j);
                    cnt++; // 그림의 개수
                }
            }
        }
        System.out.println(cnt);
        System.out.println(area);
    }

    private static void bfs(int r, int c) {
        Queue<Point> queue = new LinkedList<>();
        queue.add(new Point(r, c));
        visit[r][c] = true;

        int a = 1; // 각 그림의 넓이
        while (!queue.isEmpty()) {
            Point p = queue.poll();

            for (int d = 0; d < 4; d++) {
                int nr = p.r + dr[d];
                int nc = p.c + dc[d];

                // 가로나 세로로 연결할 다음 부분이 범위가 넘어가거나
                // 방문했던 부분이거나
                // 색칠이 안된 부분(0)이면 continue
                if (nr < 0 || nc < 0 || nr >= n || nc >= m || visit[nr][nc] || arr[nr][nc] == 0) continue;

                // 위의 조건이 아니라면,
                // 그림이 연결된 조건이기 때문에 queue add
                // 방문 처리
                // 각 area 증가
                queue.add(new Point(nr, nc));
                visit[nr][nc] = true;
                a++;
            }
        }
        area = Math.max(area, a); // 각 그림의 넓이 중 가장 넓은 것으로 갱신 
    }
}
