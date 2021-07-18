package programmers.Level1;

public class P67256_키패드누르기 {
    public static void main(String[] args) {
        int[] numbers1 = {1, 3, 4, 5, 8, 2, 1, 4, 5, 9, 5};
        String hand1 = "right";
        String ans1 = solution(numbers1, hand1);
        System.out.println(ans1);

        int[] numbers2 = {7, 0, 8, 2, 8, 3, 1, 5, 7, 6, 2};
        String hand2 = "left";
        String ans2 = solution(numbers2, hand2);
        System.out.println(ans2);

        int[] numbers3 = {1, 2, 3, 4, 5, 6, 7, 8, 9, 0};
        String hand3 = "right";
        String ans3 = solution(numbers3, hand3);
        System.out.println(ans3);
    }

    private static String solution(int[] numbers, String hand) {
        String answer = "";
        int posL = -1, posR = -1; // 초기 왼손과 오른손의 위치
        for(int number : numbers){
            if(number == 1 || number == 4 || number == 7){
                answer += "L";
                posL = number;
            }else if(number == 3 || number == 6 || number == 9){
                answer += "R";
                posR = number;
            }else{
                // 2, 5, 8, 0 숫자일 때 어느 손의 위치와 가까운가
                int distL = getDistance(number, posL);
                int distR = getDistance(number, posR);

                if(distL > distR){
                    answer += "R";
                    posR = number;
                }else if(distL < distR){
                    answer += "L";
                    posL = number;
                }else{
                    if(hand.equals("right")) {
                        answer += "R";
                        posR = number;
                    }else{
                        answer += "L";
                        posL = number;
                    }
                }
            }
        }
        return answer;
    }

    private static int getDistance(int number, int position) {
        // 키패드를 이차원 배열로 표현하여
        int[][] keypad = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}, {-1, 0, -1}};
        // 루프를 돌며 해당 숫자와 왼손 & 오른손이 있는 위치 추출
        int x1 = 0, y1 = 0, x2 = 0, y2 = 0;
        for(int i = 0; i < 4; i++){
            for(int j = 0; j < 3; j++){
                if(keypad[i][j] == number){ x1 = i; y1 = j;}
                if(keypad[i][j] == position){ x2 = i; y2 = j;}
            }
        }
        // 눌러야 할 숫자와 손 위치 거리 리턴
        int dist = Math.abs(x2 - x1) + Math.abs(y2 - y1);
        return dist;
    }
}
