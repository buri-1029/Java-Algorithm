package programmers.level1;

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
        // 현재 체육수업을 들을 수 있는 학생의 수
        int answer = n - lost.length;

        // 배열 -> 리스트
        ArrayList<Integer> lostList = new ArrayList<>();
        ArrayList<Integer> reserveList = new ArrayList<>();
        for(int l : lost) lostList.add(l);
        for(int r : reserve) reserveList.add(r);

        // 여벌 체육복을 가져온 학생이 체육복을 도난당한 경우
        for(int l : lost){
            if(reserveList.contains(l)) {
                // 빌려줄 수 없고, 자신이 입어야하기 때문에
                // 두 리스트에서 제거
                lostList.remove((Integer) l);
                reserveList.remove((Integer) l);
                // 체육수업을 들을 수 있음.
                answer++;
            }
        }

        for(int l : lostList){
            // 여벌 체육복이 있는 학생이 이제 없다면 끝
            if(reserveList.isEmpty()) break;
            for(int r : reserveList){
                // r번 학생이 l번 학생의 뒷번호이거나 앞번호이면
                if(r == l - 1 || r == l + 1){
                    // 체육수업을 들을 수 있음.
                    reserveList.remove((Integer) r);
                    answer++;
                    break;
                }
            }
        }

        return answer;
    }
}
