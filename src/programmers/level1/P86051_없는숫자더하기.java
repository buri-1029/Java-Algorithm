package programmers.level1;

public class P86051_없는숫자더하기 {
    public static void main(String[] args) {
        int[] numbers1 = {1,2,3,4,6,7,8,0};
        int[] numbers2 = {5,8,4,0,6,7,9};

        int answer1 = solution(numbers1);
        System.out.println(answer1);

        int answer2 = solution(numbers2);
        System.out.println(answer2);
    }

    private static int solution(int[] numbers) {
        int answer = 45;

        for(int i : numbers){
            answer -= i;
        }

        return answer;
    }
}
