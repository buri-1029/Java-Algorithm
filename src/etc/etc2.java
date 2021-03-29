package etc;

import java.util.HashSet;
import java.util.Set;
// 프로그래밍2
public class etc2 {
    public static void main(String[] args) {
        String str = "abac";
        solution(str);
    }

    static public int solution(String s) {
        int answer = 0;
        int cnt = 1;
        Set<String> set = new HashSet<>();

        while (true) {
            if (cnt > s.length()) break;
            for (int i = 0; i <= s.length() - cnt; i++) {
                set.add(s.substring(i, i + cnt));
            }
            cnt++;
        }
        for (String str : set) {
            if (!duplicates(str))
                answer++;
        }
        return answer;
    }

    static public boolean duplicates(String s) {
        String[] arr = s.split("");
        Set<String> check = new HashSet<>();
        for (String str : arr) {
            if (check.contains(str)) return true;
            check.add(str);
        }
        return false;
    }
}
