package etc;

//class Solution {
//    public int solution(int n) {
//        int answer = 0;
//        while(n > 0){
//            answer += n / 5;
//            n /= 5;
//        }
//        return answer;
//    }
//}

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

public class etc1 {
    static class Point{
        int time;
        int idx;
        Point(int time, int idx){
            this.time = time;
            this.idx = idx;
        }
    }
    public static void main(String[] args) {
        int N = 3;
        int[] times = {4, 2, 2, 5, 3};
        solution(N, times);
    }
    static public int[] solution(int N, int[] coffee_times) {
        int[] answer = new int[coffee_times.length];
        ArrayList<Point> arrList = new ArrayList<>();
        for(int i = 0; i < N; i++){
            arrList.add(new Point(coffee_times[i], i + 1));
        }
        if(N == 1){
            for(int i = 0; i < coffee_times.length; i++){
                answer[i] = i + 1;
            }
        }else{
            int idx = 0;
            int next = N ;
            while(true){
                if(next == coffee_times.length) break;
                for(int i = 0; i < N; i++) {
                    arrList.set(i, new Point(arrList.get(i).time - 1,arrList.get(i).idx));
                    System.out.println(i + " " + arrList.get(i).time);
                    if(arrList.get(i).time == 0){
                        answer[idx] = arrList.get(i).idx;
                        idx+=1;
                        arrList.remove(i);
                        arrList.add(new Point(coffee_times[next-1], next++));
                    }
                }
            }
        }
        for (int i = 0; i< answer.length; i++){
            System.out.println(answer[i]);
        }
        return answer;
    }
}
