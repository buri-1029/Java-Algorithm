package programmers.level2;

public class P17679_프렌즈4블록 {

	public static void main(String[] args) {
		int m = 6;
		int n = 6;
		String[] board = {"TTTANT", "RRFACC", "RRRFCC", "TRRRAA", "TTMMMF", "TMMTTJ"};
		System.out.println(solution(m, n, board));
	}

	public static int solution(int m, int n, String[] board) {
		int answer = 0;

		char[][] arr = new char[m][n];
		for (int i = 0; i < m; i++) {
			arr[i] = board[m - i - 1].toCharArray();
		}

		while (true) {
			boolean flag = true;
			boolean[][] check = new boolean[m][n];

			for (int i = 0; i < m - 1; i++) {
				for (int j = 0; j < n - 1; j++) {
					if (arr[i][j] == '-') {
						continue;
					}

					char a = arr[i][j];

					if (arr[i][j + 1] == a && arr[i + 1][j] == a && arr[i + 1][j + 1] == a) {
						check[i][j] = true;
						check[i][j + 1] = true;
						check[i + 1][j] = true;
						check[i + 1][j + 1] = true;
						flag = false;
					}
				}
			}

			if (flag) {
				break;
			}

			for (int i = 0; i < m; i++) {
				for (int j = 0; j < n; j++) {
					if (check[i][j]) {
						arr[i][j] = '-';
						answer++;
					}
				}
			}

			for (int i = 0; i < m; i++) {
				for (int j = 0; j < n; j++) {
					if (arr[i][j] == '-') {
						for (int k = i; k < m; k++) {
							if (arr[k][j] == '-') {
								continue;
							}

							arr[i][j] = arr[k][j];
							arr[k][j] = '-';

							break;
						}
					}
				}
			}
		}

		return answer;
	}

}
