package programmers.level1;

import java.util.*;

public class P42889_실패율 {
    public static void main(String[] args) {
        int n1 = 5;
        int[] stages1 = {2, 1, 2, 6, 2, 4, 3, 3};
        int[] ans1 = solution(n1, stages1);
        System.out.println(Arrays.toString(ans1));

        int n2 = 4;
        int[] stages2 = {4,4,4,4,4};
        int[] ans2 = solution(n2, stages2);
        System.out.println(Arrays.toString(ans2));
    }

    private static int[] solution(int n, int[] stages) {
        // 각 스테이지에 도달하지 못한 플레이어 수 저장
        int[] tmp = new int[n + 1];
        for(int i = 0; i < stages.length; i++){
            tmp[stages[i]-1]++;
        }

        int before = 0; // 이전 스테이지까지 클리어하지 못한 플레이어 수 총합
        Map<Integer, Double> map = new HashMap<>(n); // <스테이지, 실패율>
        for(int i = 0; i < n; i++){
            // 실패율 = 클리어하지 못한 플레이어의 수/(스테이지에 도달한 플레이어 수 = 총 플레이어 수 - before)
            double fail = (double)tmp[i]/(double)(stages.length - before);
            map.put(i + 1, fail);
            before += tmp[i];
        }

        // value(실패율) 기준 내림차순, key(스테이지) 기준 오름차순 정렬
        List<Map.Entry<Integer, Double>> list = new LinkedList<>(map.entrySet());
        Collections.sort(list, new Comparator<Map.Entry<Integer, Double>>() {
            @Override
            public int compare(Map.Entry<Integer, Double> o1, Map.Entry<Integer, Double> o2) {
                if (o2.getValue() - o1.getValue() > 0) return 1;
                if (o2.getValue() - o1.getValue() < 0) return -1;
                return o1.getKey() - o2.getKey();
            }
        });

        int[] answer = new int[n];
        for(int i = 0; i < n; i++) {
            answer[i] = list.get(i).getKey();
        }
//        int i = 0;
//        for (Iterator<Map.Entry<Integer, Double>> iter = list.iterator(); iter.hasNext();) {
//            Map.Entry<Integer, Double> entry = iter.next();
//            answer[i++] = entry.getKey();
//        }
        return answer;
    }
}
