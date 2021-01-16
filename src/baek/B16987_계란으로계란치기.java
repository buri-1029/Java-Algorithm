package baek;

import java.util.Scanner;

//백트래킹은 재귀 호출
public class B16987_계란으로계란치기 {

	static int N;
	static Data[] list;
	static int res;

	static class Data { // 메모리 최적화 시킬거면 배열 or 리스트
		int S;
		int W;

		public Data(int S, int W) {
			this.S = S;
			this.W = W;
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// BufferedReader br = null;
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();

		list = new Data[N];

		for (int i = 0; i < N; i++) {
			list[i] = new Data(sc.nextInt(), sc.nextInt());
		}

		dfs(0, 0);
		System.out.println(res);
	}

	static void dfs(int idx, int cnt) {
//		종료조건
		if (idx == N) {
			//res = res > cnt ? res : cnt;
			res = Math.max(res, cnt);
			return;
		}
//		손에 든 계란이 깨졌거나 깨지지 않은 다른 계란이 없으면 치지 않고 넘어간다.
		if (list[idx].S <= 0 || cnt == N - 1) {
			dfs(idx + 1, cnt);
			return;
		}
//		구현
		int nCnt = cnt;
		for (int i = 0; i < N; i++) {
			if(i == idx) {
				continue;
			}
			if(list[i].S <= 0) {
				continue;
			}
			list[idx].S -= list[i].W;
			list[i].S -= list[idx].W;
			if(list[idx].S <= 0) {
				cnt++;
			}
			if(list[i].S <= 0) {
				cnt++;
			}
			dfs(idx+1, cnt);
			list[idx].S += list[i].W;
			list[i].S += list[idx].W;
			cnt = nCnt;
		}

//		재귀호출		
	}
}
