package baek;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Scanner;

public class B17140_이차원배열과연산 {
	static int r, c, k;

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[][] A = new int[100][100];
		Scanner sc = new Scanner(System.in);
		r = sc.nextInt();
		c = sc.nextInt();
		k = sc.nextInt();

		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 3; j++) {
				A[i][j] = sc.nextInt();
			}
		}

		int time = 0;
		int row = 3, col = 3;
		while (A[r - 1][c - 1] != k) {
			if (time > 100) {  // 시간이 100 넘어가버리면 -1 출력
				System.out.println(-1);
				return;
			}

			if (row >= col) { // R연산
				int max = Integer.MIN_VALUE; // 최대 열 값 확인하기 위한 변수
				for (int r = 0; r < row; r++) {
					HashMap<Integer, Integer> map = new HashMap<>(); // 수, 수의 등장 횟수 저장하기 위한 map
					for (int c = 0; c < col; c++) {
						int now = A[r][c];
						if (now != 0) { // 0은 무시
							if (!map.containsKey(now)) { // map에 포함되어 있지않으면 
								map.put(now, 1);
							} else {	// 이미 있으면
								map.put(now, map.get(now) + 1); 
							}
						}
					}
					
					// map를 정렬한 list 요소 읽어오기
					Iterator it = sortByValue(map).iterator(); 
					Arrays.fill(A[r], 0); // A배열 : r번째 행 0으로 초기화

					/** ***************************** */
					int cnt = 0; // 열 개수
					while (it.hasNext()) {
						if (cnt >= 100) // 열의 크기 100 넘어가면 break,
							break;
						int num = (int) it.next();
						A[r][cnt++] = num;	// 열의 개수 증가하면서 "수,
						A[r][cnt++] = map.get(num);	// 수의 등장횟수" A[r][cnt]에 추가
					}
					/** ***************************** */
					max = Math.max(max, cnt); // 최대 열의 수 구하기
				}
				col = max; // 열의 크기 최대 값으로 변환

			} else { // C연산
				int max = Integer.MIN_VALUE;
				for (int c = 0; c < col; c++) {
					HashMap<Integer, Integer> map = new HashMap<>();
					for (int r = 0; r < row; r++) {
						int now = A[r][c];
						if (now != 0) {
							if (!map.containsKey(now)) {
								map.put(now, 1);
							} else {
								map.put(now, map.get(now) + 1);
							}
						}
					}

					Iterator it = sortByValue(map).iterator();
					for (int r = 0; r < row; r++) {
						A[r][c] = 0;  
					}
					/** ***************************** */
					int cnt = 0; // 행 개수
					while (it.hasNext()) {
						if (cnt >= 100) // 행의 크기 100 넘어가면 break,
							break;
						int num = (int) it.next();
						A[cnt++][c] = num;	// 행의 개수 증가하면서 "수,
						A[cnt++][c] = map.get(num); // 수의 등장횟수" A[cnt][c]에 추가
					}
					/** ***************************** */
					max = Math.max(max, cnt);
				}
				row = max;
			}
			time++;
		}
		System.out.println(time);
	}

	private static ArrayList<Integer> sortByValue(HashMap<Integer, Integer> map) {
		ArrayList<Integer> list = new ArrayList<Integer>(map.keySet());
		Collections.sort(list, new Comparator<Integer>() {
		
			// 수의 등장 횟수로 정렬
			public int compare(Integer o1, Integer o2) {
				if (map.get(o1) == map.get(o2))	// 같으면
					return Integer.compare(o1, o2);	// 키 값(수)으로 정렬
				return Integer.compare(map.get(o1), map.get(o2));
			}
		});
		return list;
	}
}
