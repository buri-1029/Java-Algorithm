package programmers.Level1;

import java.util.ArrayList;
import java.util.Arrays;

public class P12906_같은숫자는싫어 {
    public static void main(String[] args) {
        int[] arr1 = {1, 1, 3, 3, 0, 1, 1};
        int[] arr2 = {4, 4, 4, 3, 3};

        int[] answer1 = solution(arr1);
        int[] answer2 = solution(arr2);

        System.out.println(Arrays.toString(answer1));
        System.out.println(Arrays.toString(answer2));
    }

    private static int[] solution(int[] arr) {
        ArrayList<Integer> list = new ArrayList<>();
        // 처음은 그냥 넣어주고
        list.add(arr[0]);
        // 그 다음 인덱스부터 확인
        for(int i = 1; i < arr.length; i++){
            if(arr[i - 1] != arr[i]){ // 전 인덱스의 숫자와 같으면 연속되니깐
                list.add(arr[i]);     // 아니면 리스트에 추가
            }
        }

        // 배열로 리턴
        int[] answer = new int[list.size()];
        for(int i = 0; i < list.size(); i++){
            answer[i] = list.get(i);
        }
        return answer;
    }
}
