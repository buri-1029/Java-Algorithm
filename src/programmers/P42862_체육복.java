package programmers;

import java.util.ArrayList;


public class P42862_체육복 {
    public static void main(String[] args) {
        int n1 = 5;
        int[] lost1 = {2, 4};
        int[] reserve1 = {1, 3, 5};

        int ans1 = solution(n1, lost1, reserve1);
        System.out.println(ans1);

        int n2 = 5;
        int[] lost2 = {2, 4};
        int[] reserve2 = {3};

        int ans2 = solution(n2, lost2, reserve2);
        System.out.println(ans2);

        int n3 = 5;
        int[] lost3 = {1, 2, 4, 5};
        int[] reserve3 = {2, 3, 4};

        int ans3 = solution(n3, lost3, reserve3);
        System.out.println(ans3);
    }

    /*
     * remove method
     *  - remove(int index) : 해당 인덱스의 값 제거
     *  - remove(Object o) : 해당 값 제거
     */
    private static int solution(int n, int[] lost, int[] reserve) {
        int answer = n - lost.length;

        ArrayList<Integer> lostList = new ArrayList<>();
        ArrayList<Integer> reserveList = new ArrayList<>();

        for(int l : lost) lostList.add(l);
        for(int r : reserve) reserveList.add(r);

        for(int l : lost){
            if(reserveList.contains(l)) {
                answer++;
                lostList.remove((Integer) l);
                reserveList.remove((Integer) l);
            }
        }

        for(int l : lostList){
            if(reserveList.isEmpty()) break;
            for(int r : reserveList){
                if(r == l - 1 || r == l + 1){
                    reserveList.remove((Integer) r);
                    answer++;
                    break;
                }
            }
        }

        return answer;
    }
}
