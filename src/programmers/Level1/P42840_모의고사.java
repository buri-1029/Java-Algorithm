package programmers.Level1;

import java.util.ArrayList;
import java.util.Arrays;

public class P42840_모의고사 {
    public static void main(String[] args) {
        int[] answers1 = {1, 2, 3, 4, 5};
        int[] answer1 = solution(answers1);
        System.out.println(Arrays.toString(answer1));

        int[] answers2 = {1, 3, 2, 4, 2};
        int[] answer2 = solution(answers2);
        System.out.println(Arrays.toString(answer2));
    }

    private static int[] solution(int[] answers) {
        int[] x = {1, 2, 3, 4, 5};
        int[] y = {2, 1, 2, 3, 2, 4, 2, 5};
        int[] z = {3, 3, 1, 1, 2, 2, 4, 4, 5, 5};

        int[] tmp = new int[3];

        for(int i = 0; i < answers.length; i++){
            if(answers[i] == x[i%x.length]) tmp[0] ++;
            if(answers[i] == y[i%y.length]) tmp[1] ++;
            if(answers[i] == z[i%z.length]) tmp[2] ++;
        }
        int max = Math.max(tmp[0], Math.max(tmp[1], tmp[2]));

        ArrayList<Integer> list = new ArrayList<>();
        if(max == tmp[0]) list.add(1);
        if(max == tmp[1]) list.add(2);
        if(max == tmp[2]) list.add(3);

        int[] answer = new int[list.size()];
        for(int i = 0; i < list.size(); i++){
            answer[i] = list.get(i);
        }

        // 다른 사람 풀이
        // return list.stream().mapToInt(i->i.intValue()).toArray();
        return answer;

//        int max = Arrays.stream(tmp).max().getAsInt();
//        int cnt = 0, idx = 0;
//        for(int n : tmp){
//            if(max == n) cnt++;
//        }
//
//        int[] answer = new int[cnt];
//        for(int i = 0; i < tmp.length; i++){
//            if(tmp[i] == max) answer[idx++] = i + 1;
//        }
//        return answer;
    }
}
