package baek;

import java.util.Scanner;

public class B1926_그림DFS {
    static int n, m, cnt = 0, area, max = 0;
    static int[][] arr;
    static boolean[][] visit;
    static int[] dr = {-1, 1, 0, 0};
    static int[] dc = {0, 0, -1, 1};

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
                area = 1;
                if (arr[i][j] == 1 && !visit[i][j]) {
                    dfs(i, j);
                    cnt++; // 그림의 개수
                    if(area > max){
                        max = area;
                    }
                }
            }
        }
        System.out.println(cnt);
        System.out.println(max);
    }

    private static void dfs(int r, int c) {
        visit[r][c] = true;

        for(int d = 0; d < 4; d++){
            int nr = r + dr[d];
            int nc = c + dc[d];

            if (nr < 0 || nc < 0 || nr >= n || nc >= m || visit[nr][nc] || arr[nr][nc] == 0) continue;

            area++;
            dfs(nr, nc);
        }
    }
}
