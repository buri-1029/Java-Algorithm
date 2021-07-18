package programmers.Level1;

import java.util.ArrayList;
import java.util.Collections;

public class P68644_두개뽑아서더하기 {
    static ArrayList<Integer> ans = new ArrayList<>();
    public static void main(String[] args) {
        int[] numbers1 = {2, 1, 3, 4, 1};
        int[] numbers2 = {5, 0, 2, 7};

        int[] ans1 = solution(numbers1);
    }

    static public int[] solution(int[] numbers) {
        int[] select = new int[2];
        combination(0, 0, numbers, select);

        Collections.sort(ans);
        int[] answer = new int[ans.size()];
        for(int i = 0; i < answer.length; i++){
            answer[i] = ans.get(i);
        }
        return answer;
    }

    private static void combination(int idx, int k, int[] numbers, int[] select) {
        if(k == 2){
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
