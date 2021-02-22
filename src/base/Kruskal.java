package base;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

/**
 * Kruskal 알고리즘
 *
 * - 탐욕적인 방법(greedy)를 이용하여 모든 정점을 최소비용으로 연결하여 최적해답을 구하는 알고리즘
 * - 간선을 하나씩 선택해서 MST를 찾는 알고리즘
 *
 * - 과정
 * 		1. 최초, 모든 간선을 가중치에 따라 오름차순으로 정렬
 * 		2. 가중치가 가장 낮은 간선부터 선택하면서 트리를 증가시키고, 사이클이 존재하면 다음으로 가중치가 낮은 간선 선택
 * 		3. n-1개의 간선이 선택될 때까지 2번 반복
 *
 */
public class Kruskal {
    static int[] parents; // 정점의 부모 노드를 저장할 배열

    static class Edge implements Comparable<Edge> {
        int s, e, c;

        Edge(int s, int e, int c) {
            this.s = s;
            this.e = e;
            this.c = c;
        }

        @Override
        public int compareTo(Edge e) {
            // TODO Auto-generated method stub
            if (this.c < e.c) {
                return -1;
            } else if (this.c > e.c) {
                return 1;
            }
            return 0;
        }
    }

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        Scanner sc = new Scanner(System.in);
        int V = sc.nextInt(); // 정점의 개수
        int E = sc.nextInt(); // 간선의 개수

        ArrayList<Edge> edges = new ArrayList<>();
        parents = new int[V + 1];

        for (int i = 0; i < E; i++) {
            int A = sc.nextInt(); // A 정점
            int B = sc.nextInt(); // B 정점
            int C = sc.nextInt(); // C 가중치
            edges.add(new Edge(A, B, C));
        }

        // 가중치 오름차순으로 정렬
        Collections.sort(edges);

        // makeset
        for (int i = 0; i < V; i++) {
            parents[i] = i;
        }

        int sum = 0;
        int cnt = 0;

        // 간선만큼 돌면서 싸이클이 아니면 더하고 부모 병합
        for (int i = 0; i < E; i++) {
            Edge edge = edges.get(i);
            if (find(edge.s) != find(edge.e)) {
                sum += edge.c; // 가중치 증가
                union(edge.s, edge.e);
                cnt++;
                if (cnt == V - 1) { // 모든 정점 처리했으면 break;
                    break;
                }
            }
        }
        System.out.println(sum);
    }

    /** 서로소 집합 */
    private static void union(int x, int y) {
        int px = find(x); // x의 부모노드를 찾아서
        int py = find(y); // y의 부모노드를 찾아서

        if (px >= py)	// 비교 후
            parents[px] = py; // y의 부모노드를 x의 부모노드로 변경
        else
            parents[py] = px; // x의 부모노드를 y의 부모노드로 변경
    }

    private static int find(int x) { // x의 부모노드 반환
        if (parents[x] == x) {
            return parents[x];
        } else {
            return find(parents[x]);
        }
    }
}