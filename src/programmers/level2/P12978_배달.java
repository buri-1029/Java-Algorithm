package programmers.level2;

public class P12978_배달 {

	public static void main(String[] args) {
		int N = 5;
		int[][] road = {{1, 2, 1}, {2, 3, 3}, {5, 2, 2}, {1, 4, 2}, {5, 3, 1}, {5, 4, 2}};
		int K = 3;
		System.out.println(solution(N, road, K));
	}

	// 플로이드 와샬 알고리즘
	public static int solution(int N, int[][] road, int K) {
		int answer = 0;
		int[][] map = new int[N][N];

		for (int i = 0; i < map.length; i++) {
			for (int j = 0; j < map.length; j++) {
				if (i == j) {
					map[i][j] = 0;
					continue;
				}

				map[i][j] = 500001;
			}
		}

		for (int[] arr : road) {
			if (map[arr[0] - 1][arr[1] - 1] < arr[2]) {
				continue;
			}

			map[arr[0] - 1][arr[1] - 1] = arr[2];
			map[arr[1] - 1][arr[0] - 1] = arr[2];
		}

		for (int k = 0; k < N; k++) {
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					if (map[i][j] > map[i][k] + map[k][j]) {
						map[i][j] = map[i][k] + map[k][j];
					}
				}
			}
		}

		for (int i = 0; i < map.length; i++) {
			if (map[0][i] <= K) {
				answer++;
			}
		}

		return answer;
	}
}
