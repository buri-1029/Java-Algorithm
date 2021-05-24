package programmers;

import java.util.*;

public class P72411_메뉴리뉴얼 {
    static Map<String, Integer> map = new HashMap<>();
    static int[] max = new int[11];
    public static void main(String[] args) {
        String[] orders1 = {"ABCFG", "AC", "CDE", "ACDE", "BCFG", "ACDEH"};
        int[] course1 = {2, 3, 4};

        String[] orders2 = {"ABCDE", "AB", "CD", "ADE", "XYZ", "XYZ", "ACD"};
        int[] course2 = {2, 3, 5};

        String[] orders3 = {"XYZ", "XWY", "WXA"};
        int[] course3 = {2, 3, 4};

        String[] answer1 = solution(orders1, course1);
    }

    private static String[] solution(String[] orders, int[] course) {
        for(int i = 0; i < orders.length; i++){
            String[] order = orders[i].split("");
            Arrays.sort(order);
            for(int j = 0; j < course.length; j++){
                if(order.length >= course[j]) {
                    String[] select = new String[course[j]];
                    combination(order, select, 0, 0);
                }
            }
        }
        List<String> list = new ArrayList<>();
        for(int c : course){
            for(Map.Entry<String, Integer> map : map.entrySet()){
                if(c == map.getKey().length() && max[c] == map.getValue() && map.getValue() > 1){
                    list.add(map.getKey());
                }
            }
        }
        Collections.sort(list);
        String[] answer = new String[list.size()];
        for(int i = 0; i < answer.length; i++){
            answer[i] = list.get(i);
        }
        return  answer;
    }

    private static void combination(String[] order, String[] select, int idx, int k) {
        if(k == select.length){
            String str = "";
            for(int i = 0; i < select.length; i++){
                str += select[i];
            }
            if(map.containsKey(str)){
                int cnt = map.get(str);
                cnt++;
                map.put(str, cnt);
                if(max[str.length()] < cnt) {
                    max[str.length()] = cnt;
                }
            }else{
                map.put(str, 1);
                if(max[str.length()] == 0)
                    max[str.length()] = 1;
            }
            return;
        }
        for(int i = idx; i < order.length; i++){
            select[k] = order[i];
            combination(order, select, i + 1, k + 1);
        }
    }
}
