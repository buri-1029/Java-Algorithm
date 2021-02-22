package base;

import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.Scanner;

/**
 * Prim 알고리즘
 *
 * - 시작 정점에서부터 출발하여 신장트리 집합을 단계적으로 확장해 나가는 방법
 * - 하나의 정점에서 연결된 간선들 중에 하나씩 선택하면서 MST를 만들어가는 알고리즘
 *
 * - 과정
 * 		1. 임의 정점을 하나 선택해서 시작
 * 		2. 선택한 정점과 인접하는 정점들 중 최소비용의 간선이 존재하는 정점 선택
 * 		3. 모든 정점이 선택될 때까지 1,2 반복
 *
 */
public class Prim {

    static class Edge implements Comparable<Edge> {
        int v, w; // 자신과 연결된 정점과 가중치

        public Edge(int v, int w) {
            super();
            this.v = v;
            this.w = w;
        }

        @Override
        public int compareTo(Edge o) {
            // TODO Auto-generated method stub
            return this.w - o.w;
        }
    }

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        Scanner sc = new Scanner(System.in);
        int V = sc.nextInt(); // 정점의 개수
        int E = sc.nextInt(); // 간선의 개수

        ArrayList<Edge>[] adj = new ArrayList[V + 1]; // 정점의 연결 상태를 저장할 리스트
        for (int i = 1; i <= V; i++) { // 초기화
            adj[i] = new ArrayList<>();
        }

        for (int i = 0; i < E; i++) {
            int A = sc.nextInt();
            int B = sc.nextInt();
            int C = sc.nextInt();
            // 정점 A와 정점 B가 가중치 C로 연결
            adj[A].add(new Edge(B, C));
            adj[B].add(new Edge(A, C));
        }

        // 방문했는지 확인하기 위한 boolean 배열
        boolean[] visited = new boolean[V + 1];
        visited[1] = true;

        // 비용이 가장 작은 간선을 뽑기 위한 우선순위 큐
        PriorityQueue<Edge> pq = new PriorityQueue<>();
        // 시작 정점을 1번으로 지정
        pq.addAll(adj[1]);

        int ans = 0; // 최종 최소 비용
        int cnt = 1; // 방문된 정점 개수

        while (cnt < V) { // 모든 정점이 연결될 때까지 (V : 정점의 개수)
            Edge edge = pq.poll(); // 가장 작은 간선 poll()

            if (!visited[edge.v]) { // 방문한 정점이 아니라면
                visited[edge.v] = true;
                ans += edge.w; // 가중치 증가
                pq.addAll(adj[edge.v]);
                cnt++;
            }
        }
        System.out.println(ans);
    }
}