package programmers.level1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class P68644_두개뽑아서더하기 {
    // 더해서 만들 수 있는 모든 수를 담을 리스트
    static ArrayList<Integer> ans;
    public static void main(String[] args) {
        int[] numbers1 = {2, 1, 3, 4, 1};
        int[] numbers2 = {5, 0, 2, 7};

        int[] ans1 = solution(numbers1);
        int[] ans2 = solution(numbers2);

        System.out.println(Arrays.toString(ans1));
        System.out.println(Arrays.toString(ans2));
    }

    static public int[] solution(int[] numbers) {
        ans = new ArrayList<>();
        int[] select = new int[2];
        // 조합 이용
        combination(0, 0, numbers, select);

        // 정렬
        Collections.sort(ans);

        // 배열로
        int[] answer = new int[ans.size()];
        for(int i = 0; i < answer.length; i++){
            answer[i] = ans.get(i);
        }
        return answer;
    }

    private static void combination(int idx, int k, int[] numbers, int[] select) {
        if(k == 2){ // 두 개의 수가 뽑였다면
            // '리스트에 없는 수'라면 추가
            if(!ans.contains(select[0]+select[1]))
                ans.add(select[0]+select[1]);
            return;
        }

        for(int i = idx; i < numbers.length; i++ ){
            select[k] = numbers[i];
            combination(i+1,k+1,numbers,select);
        }
    }
}
