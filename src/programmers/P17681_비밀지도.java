package programmers;

import java.util.Arrays;

public class P17681_비밀지도 {
    public static void main(String[] args) {
        int n1 = 5;
        int[] arr1 = {9, 20, 28, 18, 11};
        int[] arr2 = {30, 1, 21, 17, 28};

        String[] ans1 = solution(n1, arr1, arr2);
        System.out.println(Arrays.toString(ans1));

        int n2 = 6;
        int[] arr3 = {46, 33, 33 ,22, 31, 50};
        int[] arr4 = {27 ,56, 19, 14, 14, 10};

        String[] ans2 = solution(n2, arr3, arr4);
        System.out.println(Arrays.toString(ans2));
    }

    private static String[] solution(int n, int[] arr1, int[] arr2) {
        String[] answer = new String[n];
        int[][] encoding1 = new int[n][n];
        int[][] encoding2 = new int[n][n];

        for(int i = 0; i < arr1.length; i++){
            int tmp = arr1[i], idx = n - 1;
            while(tmp > 0){
                if(tmp % 2 < 10){
                    encoding1[i][idx--] += (tmp % 2);
                    tmp /= 2;
                }
            }
        }
        for(int i = 0; i < arr2.length; i++){
            int tmp = arr2[i], idx = n - 1;
            while(tmp > 0){
                if(tmp % 2 < 10){
                    encoding2[i][idx--] += (tmp % 2);
                    tmp /= 2;
                }
            }
        }

        for(int i = 0; i < n; i++){
            String str = "";
            for(int j = 0; j < n; j++){
                if(encoding1[i][j] == 1 || encoding2[i][j] == 1) str += "#";
                else str += " ";
            }
            answer[i] = str;
        }
        return answer;
    }
}
