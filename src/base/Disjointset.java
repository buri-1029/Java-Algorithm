package base;

import java.util.Arrays;

public class Disjointset {
    static int[] parent = new int[6];
    static int N = 5;

    public static void main(String[] args) {
        N = 5;
        makeSet();

        union(0,1);
        union(1,2);
        union(1,3);
        union(2,5);

        for (int i = 0; i < N; i++) {
            System.out.println(find(i));
        }
        System.out.println(Arrays.toString(parent));
    }

    // 3. i, j를 합치는 (하나의 집합으로) 작업
    private static void union(int i, int j) {
        int pi = find(i);
        int pj = find(j);

        if(pi != pj) {
            parent[j] = pi;//
        }
        System.out.print(i + "," + j + " union:");
        System.out.println(Arrays.toString(parent));
    }

    // 2. x가 포함된 집합을 찾는 작업
    private static int find(int i) {// i의 부모를 찾는 메소드(i가 속한 집합을 찾아서 리턴)
        if(parent[i] == -1) {
            return i;

        }else {
            int pp = find(parent[i]);// 부모의 부모(조부모)를 찾아
            parent[i] = pp;// i의 부모로 조부모를 넣어주고
            return pp;// 그 조부모 값을 리턴
        }

    }

    // 1. makeSet() : 값 x을 포함하는 새로운 집합을 만드는 작업
    // x가 속한 작업을 만드는 작업
    // parent 배열을 사용해서 x의 부모 (x가 속한 집합)를 결정
    private static void makeSet() {
        Arrays.fill(parent, -1);	// 배열을 -1로 채움

//		for(int i=1;i<=N;i++) {
//			parent[i] = i;
//		}
    }
}