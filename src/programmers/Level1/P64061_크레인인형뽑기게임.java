package programmers.Level1;

import java.util.Stack;

public class P64061_크레인인형뽑기게임 {
    public static void main(String[] args) {
        int[][] board = {{0,0,0,0,0},{0,0,1,0,3},{0,2,5,0,1},{4,2,4,4,2},{3,5,1,3,1}};
        int[] moves = {1,5,3,5,1,2,1,4};

        int result = solution(board, moves);
        System.out.println(result);
    }

    private static int solution(int[][] board, int[] moves) {
        int answer = 0;
        Stack<Integer> basket = new Stack<>(); // 인형을 담을 바구니
        for(int m = 0; m < moves.length; m++){
            for(int i = 0; i < board.length; i++){
                // 인형이 있다면
                if(board[i][moves[m] - 1] != 0){
                    // 바구니가 비어있지 않고 뽑힌 인형이 이전과 같은 모양의 인형이라면
                    if(!basket.isEmpty() && basket.peek() == board[i][moves[m] - 1]){
                        // 이전의 인형 제거, 사라진 인형 개수 +2
                        basket.pop();
                        answer += 2;
                    }else{
                        basket.push(board[i][moves[m] - 1]);
                    }
                    // 뽑힌 인형은 빈칸으로 표시
                    board[i][moves[m] - 1] = 0;
                    break;
                }
            }
        }
        return answer;
    }
}
