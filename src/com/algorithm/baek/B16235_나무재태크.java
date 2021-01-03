package com.algorithm.baek;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class B16235_나무재태크 {
	static int N, M, K;
	static int[] dr = { -1, -1, -1, 0, 0, 1, 1, 1 };
	static int[] dc = { -1, 0, 1, -1, 1, -1, 0, 1 };

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		M = sc.nextInt();
		K = sc.nextInt();

		int[][] land = new int[N + 1][N + 1]; // 초기 양분 저장 배열
		int[][] A = new int[N + 1][N + 1]; // 겨울에 로봇이 주는 양분 저장 배열
		
		for (int r = 1; r <= N; r++) {
			for (int c = 1; c <= N; c++) {
				A[r][c] = sc.nextInt();
				land[r][c] = 5; // 초기 양분 5로 초기화
			}
		}
		// 나무의 위치와 나이를 저장할 ArrayList 2차원 배열
		ArrayList<Integer>[][] trees = new ArrayList[N + 1][N + 1];
		for (int r = 1; r <= N; r++) {
			for (int c = 1; c <= N; c++) {
				trees[r][c] = new ArrayList<Integer>();
			}
		}

		// 나무 정보 입력
		for (int i = 0; i < M; i++) {
			trees[sc.nextInt()][sc.nextInt()].add(sc.nextInt());
		}
		
		// K년 동안 반복
		for (int k = 0; k < K; k++) {

			/* 봄 & 여름 */
			for (int r = 1; r <= N; r++) {
				for (int c = 1; c <= N; c++) {
					int dead = 0; // 죽은 나무 영양분
					// 나무 나이로 오름차순 정렬
					Collections.sort(trees[r][c]);
					// 나이가 증가된 나무들을 따로 저장
					ArrayList<Integer> alive = new ArrayList<>();
					 
	                for (int s = 0; s < trees[r][c].size(); s++) {
	                	// 땅에 있는 양분보다 나무의 나이가 작거나 같으면 
	                    if (land[r][c] >= trees[r][c].get(s)) { 
	                        land[r][c] -= trees[r][c].get(s); // 나이만큼 양분먹고
	                        alive.add(trees[r][c].get(s) + 1); // 나이 1 증가
	                    }
	                    // 그렇지 않으면 양분을 먹지 못하고 죽는다.
	                    else { 
	                        dead += (trees[r][c].get(s) / 2);	// 2로 나눈 값으로 양분 추가
	                    }
	                }
	                // 나이가 증가된 나무들과 죽은 나무들의 영양분을
	                // 기존의 나무와 땅에 갱신
	                trees[r][c] = alive;
	                land[r][c] += dead;
				}
			}
			
			/* 가을 */
			for (int r = 1; r <= N; r++) {
				for (int c = 1; c <= N; c++) {
					for (int s = 0; s < trees[r][c].size(); s++) {
						// 번식하는 나무는 나이가 5의 배수
						if (trees[r][c].get(s) % 5 == 0) {
							for (int dir = 0; dir < 8; dir++) {
								int nr = r + dr[dir];
								int nc = c + dc[dir];

								if (nr > N || nr < 1 || nc > N || nc < 1) continue;
								// 나이가 1인 나무
								trees[nr][nc].add(1);
							}
						}
					}
				}
			}

			/* 겨울 */
			for (int r = 1; r <= N; r++) {
				for (int c = 1; c <= N; c++) {
					// 땅에 양분을 추가
					land[r][c] += A[r][c];
				}
			}
		}
		
		// 경로표 출력 
		int ans = 0;
        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= N; j++) {
                ans += trees[i][j].size();
            }
        }
        System.out.println(ans);
	}
}
