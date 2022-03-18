package programmers.level1;

public class P68935_3진법뒤집기 {
    public static void main(String[] args) {
        int n1 = 45;
        int n2 = 125;

        System.out.println(solution(n1));
        System.out.println(solution(n2));

    }

    private static int solution(int n) {
        String str = "";
        // 10진법 -> 3진법 -> 앞뒤 반전
        while(n > 0){
            if(n % 3 < 10){
                str += (n % 3);
                n /= 3;
            }
        }

        // 10진법으로 변환
        return Integer.parseInt(str,  3);
    }
}
