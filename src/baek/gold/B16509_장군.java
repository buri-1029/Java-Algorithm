package baek.gold;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class B16509_장군 {

	static int R1, C1, R2, C2, ANS = Integer.MAX_VALUE;
	static int[] dr = {-3, -2, 3, -3, 2, -2, 3, 2};
	static int[] dc = {-2, 3, 2, 2, -3, -3, -2, 3};

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		R1 = sc.nextInt(); // 상
		C1 = sc.nextInt();
		R2 = sc.nextInt(); // 왕
		C2 = sc.nextInt();

		bfs(R1, C1);
		System.out.println(ANS);
	}

	private static void bfs(int r1, int c1) {
		int[][] visited = new int[10][9];
		visited[r1][c1] = 1;

		Queue<Point> queue = new LinkedList<>();
		queue.add(new Point(r1, c1, 0));

		while (!queue.isEmpty()) {
			Point p = queue.poll();
            if (p.r == R2 && p.c == C2) {
                ANS = Math.min(ANS, p.cnt);
            }

			for (int d = 0; d < 8; d++) {
				int nr = p.r + dr[d];
				int nc = p.c + dc[d];

				if (0 <= nr && nr < 10 && 0 <= nc && nc < 9 && visited[nr][nc] == 0) {

					if (d == 0) {
                        if ((p.r - 1 == R2 && p.c == C2) || (p.r - 2 == R2 && p.c - 1 == C2)) {
                            continue;
                        } else {
                            queue.add(new Point(nr, nc, p.cnt + 1));
                            visited[nr][nc] = 1;
                        }
					}
					if (d == 1) {
                        if ((p.r == R2 && p.c + 1 == C2) || (p.r - 1 == R2 && p.c + 2 == C2)) {
                            continue;
                        } else {
                            queue.add(new Point(nr, nc, p.cnt + 1));
                            visited[nr][nc] = 1;
                        }
					}
					if (d == 2) {
                        if ((p.r + 1 == R2 && p.c == C2) || (p.r + 2 == R2 && p.c + 1 == C2)) {
                            continue;
                        } else {
                            queue.add(new Point(nr, nc, p.cnt + 1));
                            visited[nr][nc] = 1;
                        }
					}
					if (d == 3) {
                        if ((p.r - 1 == R2 && p.c == C2) || (p.r - 2 == R2 && p.c + 1 == C2)) {
                            continue;
                        } else {
                            queue.add(new Point(nr, nc, p.cnt + 1));
                            visited[nr][nc] = 1;
                        }
					}
					if (d == 4) {
                        if ((p.r == R2 && p.c - 1 == C2) || (p.r + 1 == R2 && p.c - 2 == C2)) {
                            continue;
                        } else {
                            queue.add(new Point(nr, nc, p.cnt + 1));
                            visited[nr][nc] = 1;
                        }
					}
					if (d == 5) {
                        if ((p.r == R2 && p.c - 1 == C2) || (p.r - 1 == R2 && p.c - 2 == C2)) {
                            continue;
                        } else {
                            queue.add(new Point(nr, nc, p.cnt + 1));
                            visited[nr][nc] = 1;
                        }
					}
					if (d == 6) {
                        if ((p.r + 1 == R2 && p.c == C2) || (p.r + 2 == R2 && p.c - 1 == C2)) {
                            continue;
                        } else {
                            queue.add(new Point(nr, nc, p.cnt + 1));
                            visited[nr][nc] = 1;
                        }
					}
					if (d == 7) {
						if ((p.r == R2 && p.c + 1 == C2) || (p.r + 1 == R2 && p.c + 2 == C2))
							continue;
						else {
							queue.add(new Point(nr, nc, p.cnt + 1));
							visited[nr][nc] = 1;
						}
					}
				}
			}
		}
	}

	static class Point {

		int r, c, cnt;

		Point(int r, int c, int cnt) {
			this.r = r;
			this.c = c;
			this.cnt = cnt;
		}
	}
}
