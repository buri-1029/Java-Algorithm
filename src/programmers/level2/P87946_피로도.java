package programmers.level2;

public class P87946_피로도 {

	public static int answer = 0;
	public static boolean[] visit;

	public static void main(String[] args) {
		int k = 80;
		int[][] dungeons = {{80, 20}, {50, 40}, {30, 10}};

		System.out.println(solution(k, dungeons));
	}

	public static int solution(int k, int[][] dungeons) {
		visit = new boolean[dungeons.length];

		dfs(0, k, dungeons);

		return answer;
	}

	private static void dfs(int d, int k, int[][] dungeons) {

		for (int i = 0; i < dungeons.length; i++) {
			if (!visit[i] && dungeons[i][0] <= k) {
				visit[i] = true;
				dfs(d + 1, k - dungeons[i][1], dungeons);
				visit[i] = false;
			}
		}

		answer = Math.max(answer, d);
	}

}
