package baek;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class B1697_숨바꼭질 {
	static int N, K;
	static int[] visit;

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		K = sc.nextInt();
		visit = new int[100001]; // 언니가  이동한 위치(인덱스)마다
								 // 1씩 증가하기 위한 배열
		bfs();
		System.out.println(visit[K]);
	}

	private static void bfs() {
		// TODO Auto-generated method stub
		Queue<Integer> Q = new LinkedList();
		Q.add(N);

		while (!Q.isEmpty()) {
			Integer X = Q.poll(); // X : 언니가 이동한 위치
			
			if (X == K) {	// X 값이 동생의 위치(K)와 같으면 break,
				break;
			}
			
			// 범위 주기  (0 ≤ N ≤ 100,000)
			if (X - 1 >= 0 && visit[X - 1] == 0) { // X-1 이동
				Q.add(X - 1);
				visit[X - 1] = visit[X] + 1; // 그 전 위치에 저장된 수보다 1증가
			}
			if (X + 1 <= 100000 && visit[X + 1] == 0) { // X+1 이동
				Q.add(X + 1);
				visit[X + 1] = visit[X] + 1; // 그 전 위치에 저장된 수보다 1증가
			}
			if (2 * X <= 100000 && visit[2 * X] == 0) { // 2*X 이동
				Q.add(2 * X);
				visit[2 * X] = visit[X] + 1; // 그 전 위치에 저장된 수보다 1증가
			}
		}
	}
}
