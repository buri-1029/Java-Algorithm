package baek.gold;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

/**
 * 무게가 중간인 구슬이 될 수 없는 구슬의 개수 구하기
 */
public class B2617_구슬찾기 {

	static int N, M, res = 0;
	static ArrayList<Integer>[] heavy;
	static ArrayList<Integer>[] light;
	static boolean[] visit;

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		heavy = new ArrayList[N + 1]; // 무거운 구슬을 저장하기위한 리스트
		light = new ArrayList[N + 1]; // 가벼운 구슬을 저장하기위한 리스트

		for (int i = 1; i < N + 1; i++) {
			heavy[i] = new ArrayList<>();
			light[i] = new ArrayList<>();
		}

		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			heavy[x].add(y);
			light[y].add(x);
		}

		int cnt = 0;
		/** *********************** */
		for (int i = 1; i <= N; i++) {
			visit = new boolean[N + 1];
			cnt = 0;
			cnt = dfs(heavy, i); // 현재 구슬보다 무거운 구슬이 몇 개 있는지 탐색
			if (cnt >= (N + 1) / 2) // cnt가 (N+1)/2 보다 크거나 같으면 res 증가
			{
				res++;
			}

			visit = new boolean[N + 1]; // visit 배열 초기화
			cnt = 0;
			cnt = dfs(light, i); // 현재 구슬보다 가벼운 구슬이 몇 개 있는지 탐색
			if (cnt >= (N + 1) / 2) // cnt가 (N+1)/2 보다 크거나 같으면 res 증가
			{
				res++;
			}
		}
		/** *********************** */
		System.out.println(res);
	}

	private static int dfs(ArrayList<Integer>[] list, int idx) {
		// TODO Auto-generated method stub
		int cnt = 0; // 현재 구슬과 연결된(무겁거나 가볍거나) 다른 구슬 개수
		visit[idx] = true;
		for (int j = 0; j < list[idx].size(); j++) {
			Integer n = list[idx].get(j);
			if (!visit[n]) { // 연결된 다른 구슬이 있다면 그 구슬 dfs()탐색
				cnt += dfs(list, n) + 1; // 하나씩 증가
			}
		}
		return cnt;
	}
}