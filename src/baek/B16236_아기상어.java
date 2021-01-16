package baek;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class B16236_아기상어 {
	static int N, shark_r, shark_c, shark_size = 2;
	static int min_r, min_c, min_dist;
	static int eat_cnt, res;
	static int[][] map;
	static int[][] visit;
	static int[] dr = { -1, 1, 0, 0 }; // 상하좌우
	static int[] dc = { 0, 0, -1, 1 };

	static class Loc {
		int r, c;

		public Loc(int r, int c) {
			super();
			this.r = r;
			this.c = c;
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		map = new int[N][N];
		visit = new int[N][N];
		for (int r = 0; r < N; r++) {
			for (int c = 0; c < N; c++) {
				map[r][c] = sc.nextInt();
				if (map[r][c] == 9) {
					shark_r = r;
					shark_c = c;
					map[r][c] = 0;
				}
			}
		}

		while (true) {
			init(); // 선행작업
			
			bfs();
			
			if(min_dist != 401) {
				res += visit[min_r][min_c];
				
				map[min_r][min_c] = 0;
				
				shark_r = min_r; // 아기상어 위치 갱신
				shark_c = min_c;
				
				eat_cnt++;
				
				if(shark_size == eat_cnt) {
					shark_size++;
					eat_cnt++;
				}		
			}else {
				break; // 더이상 먹을 물고기가 없으면 끝,
			}
		}
		System.out.println(res);
	}

	private static void init() {
		// -1이 방문 안한거다. -> -1로 초기화
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				visit[i][j] = -1;
			}
		}
		
		min_dist = 401;
		min_r = 21;
		min_c = 21;
	}

	private static void bfs() {
		Queue<Loc> queue = new LinkedList<>();
		queue.add(new Loc(shark_r, shark_c));
		visit[shark_r][shark_c] = 0;
		

		while (!queue.isEmpty()) {
			Loc shark = queue.poll();

			for (int d = 0; d < 4; d++) {
				int nr = shark.r + dr[d];
				int nc = shark.c + dc[d];
				
				// 범위 체크
				if (nr < 0 || nc < 0 || nr >= N || nc >= N ) continue;
				// 방문 체크 or 상어 크기 체크
				if(visit[nr][nc] != -1 || map[nr][nc] > shark_size) continue;		
				
				// 논리 체크
				visit[nr][nc] = visit[shark.r][shark.c] + 1;
				// 그 위치 물고기를 잡아 먹을 수 있으면 그 위치를 찾아서 저장하기
				
				if(map[nr][nc] != 0 && map[nr][nc] < shark_size) {
					if(min_dist > visit[nr][nc]) { // 보다 더 가까운 물고기가 있다면,
						min_dist = visit[nr][nc];
						min_r = nr;
						min_c = nc;
					}else if(min_dist == visit[nr][nc]) {
						// 거리가 가까운 물고기가 많다면, 
						// 가장 위에 있는 물고기,
						// 그러한 물고기가 여러 마리라면, 가장 왼쪽에 있는 물고기를 먹는다.
						if(min_c == nc) {
							if(min_r > nr) {
								min_r = nr;
								min_c = nc;
							}
						}else if(min_c > nc) {
							min_r = nr;
							min_c = nc;
						}
					}
				}
				queue.add(new Loc(nr,nc));
			}
		}
	}
}
