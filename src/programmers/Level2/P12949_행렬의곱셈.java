package programmers.Level2;

public class P12949_행렬의곱셈 {
    public static void main(String[] args) {
        int[][] arr1 = {{1, 4}, {3, 2}, {4, 1}};
        int[][] arr2 = {{3, 3}, {3, 3}};

        int[][] ans1 = solution(arr1, arr2);

        for(int i = 0; i < ans1.length ; i++){
            for(int j = 0; j < ans1[i].length; j++){
                System.out.print(ans1[i][j] +" ");
            }
            System.out.println();
        }

        int[][] arr3 = {{2, 3, 2}, {4, 2, 4}, {3, 1, 4}};
        int[][] arr4 = {{5, 4, 3}, {2, 4, 1}, {3, 1, 1}};

        int[][] ans2 = solution(arr3, arr4);

        for(int i = 0; i < ans2.length ; i++){
            for(int j = 0; j < ans2[i].length; j++){
                System.out.print(ans2[i][j] +" ");
            }
            System.out.println();
        }

        int[][] arr5 = {{2, 3, 2}, {4, 2, 4}, {3, 1, 4}};
        int[][] arr6 = {{5, 4}, {2, 4}, {3, 1}};

        int[][] ans3 = solution(arr5, arr6);

        for(int i = 0; i < ans3.length ; i++){
            for(int j = 0; j < ans3[i].length; j++){
                System.out.print(ans3[i][j] +" ");
            }
            System.out.println();
        }
    }

    private static int[][] solution(int[][] arr1, int[][] arr2) {
        int[][] answer = new int[arr1.length][arr2[0].length];
        for(int i = 0; i < arr1.length ; i++){
            for(int j = 0; j < arr2[0].length; j++){
                for(int k = 0; k < arr2.length; k++){
                    answer[i][j] += arr1[i][k] * arr2[k][j];
                }
            }
        }
        return answer;
    }
}
