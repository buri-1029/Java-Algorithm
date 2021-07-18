package programmers.Level2;

import java.util.ArrayList;

public class P67257_수식최대화 {
    static char[] oper = {'+', '-', '*'};
    static char[] select = new char[3];
    static boolean[] visit = new boolean[3];

    static ArrayList<Long> nums;
    static ArrayList<Character> opers;
    static Long answer;

    public static void main(String[] args) {
        answer = (long) 0;
        String str1 = "100-200*300-500+20";
        long ans1 = solution(str1);
        System.out.println(ans1);

        answer = (long) 0;
        String str2 = "50*6-3*2";
        long ans2 = solution(str2);
        System.out.println(ans2);
    }

    static public long solution(String expression) {
        // TODO Auto-generated method stub
        nums = new ArrayList<>();
        opers = new ArrayList<>();

        String num = "";
        for (int i = 0; i < expression.length(); i++) {
            if (expression.charAt(i) == '+' || expression.charAt(i) == '-' || expression.charAt(i) == '*') {
                nums.add(Long.parseLong(num));
                opers.add(expression.charAt(i));
                num = "";
            } else {
                num += expression.charAt(i);
            }
        }
        nums.add(Long.parseLong(num));

        permutation(0);

        return answer;
    }

    private static void permutation(int k) {
        // TODO Auto-generated method stub
        if (k == 3) {
            //System.out.println(Arrays.toString(select));
            ArrayList<Long> temp_nums = new ArrayList<>(nums);
            ArrayList<Character> temp_opers = new ArrayList<>(opers);
            for (int i = 0; i < 3; i++) { // 연산자 뽑은 순
                for (int j = 0; j < temp_opers.size(); j++) { // 전달받은 수식에 있는 연산자들
                    if (select[i] == temp_opers.get(j)) {
                        if (select[i] == '+') {
                            Long cal = temp_nums.get(j) + temp_nums.get(j + 1);
                            temp_nums.remove(j);
                            temp_nums.remove(j);
                            temp_nums.add(j, cal);
                            temp_opers.remove(j);
                            j--;
                        } else if (select[i] == '-') {
                            Long cal = temp_nums.get(j) - temp_nums.get(j + 1);
                            temp_nums.remove(j);
                            temp_nums.remove(j);
                            temp_nums.add(j, cal);
                            temp_opers.remove(j);
                            j--;
                        } else {
                            Long cal = temp_nums.get(j) * temp_nums.get(j + 1);
                            temp_nums.remove(j);
                            temp_nums.remove(j);
                            temp_nums.add(j, cal);
                            temp_opers.remove(j);
                            j--;
                        }
                    }
                }
            }
            answer = Math.max(answer, Math.abs(temp_nums.get(0)));
            return;
        }
        for (int i = 0; i < 3; i++) {
            if (!visit[i]) {
                visit[i] = true;
                select[k] = oper[i];
                permutation(k + 1);
                visit[i] = false;
            }
        }
    }
}
