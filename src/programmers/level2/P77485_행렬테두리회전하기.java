package programmers.level2;

import java.util.Arrays;

public class P77485_행렬테두리회전하기 {

	public static void main(String[] args) {
		int rows = 6;
		int columns = 6;
		int[][] queries = {{2, 2, 5, 4}, {3, 3, 6, 6}, {5, 1, 6, 3}};
		System.out.println(Arrays.toString(solution(rows, columns, queries)));
	}

	public static int[] solution(int rows, int columns, int[][] queries) {
		int[] answer = new int[queries.length];
		int[][] arr = new int[rows][columns];

		for (int i = 0; i < rows; i++) {
			for (int j = 0; j < columns; j++) {
				arr[i][j] = i * columns + j + 1;
			}
		}

		for (int i = 0; i < queries.length; i++) {
			int[] minPos = {queries[i][0] - 1, queries[i][1] - 1};
			int[] maxPos = {queries[i][2] - 1, queries[i][3] - 1};

			int start = arr[minPos[0]][minPos[1]];
			int min = Integer.MAX_VALUE;

			for (int j = minPos[0]; j < maxPos[0]; j++) {
				min = Math.min(min, arr[j][minPos[1]]);
				arr[j][minPos[1]] = arr[j + 1][minPos[1]];
			}

			for (int j = minPos[1]; j < maxPos[1]; j++) {
				min = Math.min(min, arr[maxPos[0]][j]);
				arr[maxPos[0]][j] = arr[maxPos[0]][j + 1];
			}

			for (int j = maxPos[0]; j > minPos[0]; j--) {
				min = Math.min(min, arr[j][maxPos[1]]);
				arr[j][maxPos[1]] = arr[j - 1][maxPos[1]];
			}

			for (int j = maxPos[1]; j > minPos[1]; j--) {
				min = Math.min(min, arr[minPos[0]][j]);
				arr[minPos[0]][j] = arr[minPos[0]][j - 1];
			}

			arr[minPos[0]][minPos[1] + 1] = start;
			answer[i] = min;
		}

		return answer;
	}
}
