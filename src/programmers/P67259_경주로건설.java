package programmers;

import java.util.LinkedList;
import java.util.Queue;

public class P67259_경주로건설 {
    static int[] dr = {-1, 0, 1, 0};
    static int[] dc = {0, -1, 0, 1};

    static class Point {
        int r, c;
        int state;
        int cost;

        public Point(int r, int c, int state, int cost) {
            super();
            this.r = r;
            this.c = c;
            this.state = state;
            this.cost = cost;
        }
    }

    public static void main(String[] args) {
        int[][] arr1 = {{0, 0, 0}, {0, 0, 0}, {0, 0, 0}};
        System.out.println(solution(arr1));

        int[][] arr2 = {{0, 0, 0, 0, 0, 0, 0, 1}, {0, 0, 0, 0, 0, 0, 0, 0}, {0, 0, 0, 0, 0, 1, 0, 0}, {0, 0, 0, 0, 1, 0, 0, 0},
                {0, 0, 0, 1, 0, 0, 0, 1}, {0, 0, 1, 0, 0, 0, 1, 0}, {0, 1, 0, 0, 0, 1, 0, 0}, {1, 0, 0, 0, 0, 0, 0, 0}};
        System.out.println(solution(arr2));
    }

    static public int solution(int[][] board) {
        int answer = Integer.MAX_VALUE;

        Queue<Point> q = new LinkedList<>();
        q.add(new Point(0, 0, -1, 0));
        board[0][0] = 1;

        while (!q.isEmpty()) {
            Point p = q.poll();

            if (p.r == board.length - 1 && p.c == board.length - 1) {
                answer = Math.min(answer, p.cost);
                continue;
            }
            for (int k = 0; k < 4; k++) {
                int nr = p.r + dr[k];
                int nc = p.c + dc[k];

                if (nr >= 0 && nr < board.length && nc >= 0 && nc < board.length && board[nr][nc] != 1) {
                    int cost = 0;

                    if (p.state == -1 || p.state == k) {
                        cost = p.cost + 100;
                    } else if (p.state != k) {
                        cost = p.cost + 600;
                    }

                    if (board[nr][nc] == 0) {
                        board[nr][nc] = cost;
                        q.add(new Point(nr, nc, k, cost));
                    } else if (board[nr][nc] >= cost) {
                        board[nr][nc] = cost;
                        q.add(new Point(nr, nc, k, cost));
                    }
                }
            }
        }
        return answer;
    }
}
