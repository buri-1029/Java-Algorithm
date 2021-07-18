package programmers.Level1;

import java.util.HashMap;

public class P42576_완주하지못한선수 {
    public static void main(String[] args) {
        String[] participant1 = {"leo", "kiki", "eden"};
        String[] completion1 = {"eden", "kiki"};

        String answer1 = solution(participant1, completion1);
        System.out.println(answer1);

        String[] participant2 = {"mislav", "stanko", "mislav", "ana"};
        String[] completion2 = {"stanko", "ana", "mislav"};

        String answer2 = solution(participant2, completion2);
        System.out.println(answer2);
    }

    private static String solution(String[] participant, String[] completion) {
        String answer = "";
        HashMap<String, Integer> marathon = new HashMap<>();

        for(String par : participant){
            if(marathon.containsKey(par)) {
                int n = marathon.get(par) + 1;
                marathon.remove(par);
                marathon.put(par, n);
            }else {
                marathon.put(par, 1);
            }
        }
        for(String com : completion){
            if(marathon.containsKey(com)){
                int n = marathon.get(com) - 1;
                marathon.remove(com);
                if(n != 0) {
                    marathon.put(com, n);
                }
            }
        }
        // 위 두 for문에 대한 다른 사람 풀이
//      for (String par : participant) marathon.put(par, marathon.getOrDefault(par, 0) + 1);
//      for (String com : completion) marathon.put(com, marathon.get(com) - 1);

        for(String ans : marathon.keySet()) {
            answer = ans;
        }

        return answer;
    }
}
