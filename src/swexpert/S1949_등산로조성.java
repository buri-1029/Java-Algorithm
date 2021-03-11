package swexpert;

import java.util.Scanner;

// 기본적인 dfs 탐색 +a
public class S1949_등산로조성 {
    static int N, K, H, max; // h = 가장 높은 봉우리
    static int[][] arr;
    static boolean[][] visit;
    static int[] dr = { 0, -1, 0, 1 };
    static int[] dc = { 1, 0, -1, 0 };
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();

        for(int tc = 1; tc <= T; tc ++){
            N = sc.nextInt();
            K = sc.nextInt();
            H = 0;
            max = 0;

            visit = new boolean[N][N];
            arr = new int[N][N];
            for(int i = 0; i < N; i++){
                for(int j = 0; j < N; j++){
                    arr[i][j] = sc.nextInt();
                    if(arr[i][j] > H)   // 가장 높은 봉우리 get
                        H = arr[i][j];
                }
            }
            for(int i = 0; i < N; i++){
                for(int j = 0; j < N; j++){
                    if(arr[i][j] == H){ // 가장 높은 봉우리인 곳에서 탐색 시작
                        visit[i][j] = true;
                        // i&j:위치, H: 현재 봉우리 높이, L: 만든 등산로 길이, cnt: 현재 공사한 카운트
                        dfs(i, j, H,1, 0);
                        visit[i][j] = false;
                    }
                }
            }
            System.out.println("#"+tc+" "+max);
        }
    }

    private static void dfs(int r, int c, int H, int L, int cnt) {
        max = Math.max(max, L);
        for(int d = 0; d < 4; d++){
            int nr = r + dr[d];
            int nc = c + dc[d];

            if(nr < 0 || nr >= N || nc < 0 || nc >= N || visit[nr][nc]) continue;

            if(H <= arr[nr][nc]){ // 이동한 봉우리 높이가 가장 높은 봉우리 높이와 같은 곳이 있다면,
                if(cnt == 0){   // 아직 공사를 안했다면,
                    if(H > arr[nr][nc] - K){ // 이동한 봉우리에서 공사를 할 수 있는 깊이를 뺀 값이 가장 높은 봉우리보다 작다면,
                        visit[nr][nc] = true;// 방문 가능
                        dfs(nr, nc, H - 1, L + 1, cnt + 1);
                        visit[nr][nc] = false;
                    }
                }
            }else{
                visit[nr][nc] = true;
                dfs(nr, nc, arr[nr][nc], L + 1, cnt);
                visit[nr][nc] = false;
            }
        }
    }
}
