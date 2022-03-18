package programmers.level1;

public class P86491_최소직사각형 {
    public static void main(String[] args) {
        int[][] sizes1 = {{60, 50}, {30, 70}, {60, 30}, {80, 40}};
        int[][] sizes2 = {{10, 7}, {12, 3}, {8, 15}, {14, 7}, {5, 15}};

        int answer1 = solution(sizes1);
        System.out.println(answer1);

        int answer2 = solution(sizes2);
        System.out.println(answer2);
    }

    private static int solution(int[][] sizes) {
        int max1 = 0;
        int max2 = 0;

        for(int i = 0; i < sizes.length; i++) {
            max1 = Math.max(max1, Math.max(sizes[i][0], sizes[i][1]));
            max2 = Math.max(max2, Math.min(sizes[i][0], sizes[i][1]));
        }

        return max1 * max2;
    }
}
