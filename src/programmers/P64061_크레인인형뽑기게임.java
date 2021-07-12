package programmers;

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
                if(board[i][moves[m] - 1] != 0){
                    if(!basket.isEmpty() && basket.peek() == board[i][moves[m] - 1]){
                        basket.pop();
                        answer+=2;
                    }else{
                        basket.push(board[i][moves[m] - 1]);
                    }
                    board[i][moves[m] - 1] = 0;
                    break;
                }
            }
        }

        return answer;
    }
}
