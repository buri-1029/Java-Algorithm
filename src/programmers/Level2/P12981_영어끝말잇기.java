package programmers.Level2;

public class P12981_영어끝말잇기 {
    public static void main(String[] args) {
        int n1 = 3;
        String[] words1 = {"tank", "kick", "know", "wheel", "land", "dream", "mother", "robot", "tank"};
        solution(n1,words1);

        int n2 = 5;
        String[] words2 = {"hello", "observe", "effect", "take", "either", "recognize", "encourage", "ensure", "establish", "hang", "gather", "refer", "reference", "estimate", "executive"};
        solution(n2,words2);

        int n3 = 2;
        String[] words3 = {"hello", "one", "even", "never", "now", "world", "draw"};
        solution(n3,words3);
    }

    static public int[] solution(int n, String[] words) {
        int[] answer = new int[2];
        int order = 1;
        String before = words[0];
        for(int i = 1; i < words.length; i++){
            if(check(words[i], i, words)){
                char last = before.charAt(before.length() - 1);
                char cur = words[i].charAt(0);
                if(last != cur) {
                    int tmp = (i+1)%n;
                    answer[0] = tmp == 0 ? n : tmp;
                    answer[1] = order;
                    break;
                }else{
                    before = words[i];
                }
            }else{
                int tmp = (i+1)%n;
                answer[0] = tmp == 0 ? n : tmp;
                answer[1] = order;
                break;
            }

            if((i+1)%n == 0) order++;
        }

        if(answer == null){
            answer[0] = 0;
            answer[1] = 0;
        }

        return answer;
    }

    private static boolean check(String word, int idx, String[] words) {
        for(int i = 0 ; i < idx; i++){
            if(word.equals(words[i]))
                // 중복된 거 있음
                return false;
        }
        // 중복된 거 없음
        return true;
    }
}
