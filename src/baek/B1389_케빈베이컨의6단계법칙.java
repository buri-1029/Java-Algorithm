package baek;

import java.util.*;
/*
    bfs 이용
 */
public class B1389_케빈베이컨의6단계법칙 {
    static int N, M, Min = Integer.MAX_VALUE, Ans;
    static ArrayList<Integer>[] adj;
    static class Point{
        int cur, cnt;

        Point(int cur, int cnt) {
            this.cur = cur;
            this.cnt = cnt;
        }
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        M = sc.nextInt();
        Ans = N+1;

        adj = new ArrayList[N+1]; // 인접리스트 이용
        for (int i = 1; i < adj.length; i++) {
            adj[i] = new ArrayList<>();
        }

        for(int i = 0; i < M; i++){
            int A = sc.nextInt();
            int B = sc.nextInt();
            adj[A].add(B); // 서로 아는 관계
            adj[B].add(A);
        }

        for(int i = 1; i < adj.length; i++){
            bfs(i); // 1번 유저부터 bfs 탐색
        }
        System.out.println(Ans);
    }

    private static void bfs(int user) {
        Queue<Point> queue = new LinkedList<>();
        queue.add(new Point(user,0));
        boolean[] visit = new boolean[N+1];
        visit[user] = true;

        int cnt = 0; // 각 유저의 케빈 베이컨 수
        while(!queue.isEmpty()){
            Point p = queue.poll();
            cnt += p.cnt;
            int size = adj[p.cur].size();
            for(int i = 0; i < size; i++){
                Integer q = adj[p.cur].get(i);
                if(!visit[q]){
                    visit[q] = true;
                    queue.add(new Point(q,p.cnt + 1));
                }
            }
        }

        // 1번 유저와
        // 1단계로 연결된 유저는 3,4로 add(3,1) cnt = 1 >> add(4,1) cnt = 2
        // 3번 유저와 연결된 유저는 1,2,4로 add(2,2) cnt = 4 >> 1,4번 유저는 방문하였으니 pass
        // 4번 유저와 연결된 유저는 1,3,5로 add(5,2) cnt = 6 >> 1,5번 유저는 방문하였으니 pass
        // 2번 유저와 연결된 3번 유저는 방문하였으니 pass
        // 5번 유저와 연결된 4번 유저는 방문하였으니 pass
        // 이제 queue 비었어? 끝!

        if(Min > cnt){
            Min = cnt;
            Ans = user;
        }
    }
}