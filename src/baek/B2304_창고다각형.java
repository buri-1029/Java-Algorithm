package baek;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;
/*
    9%부터 틀린다..stack으로 풀어야하나...
 */
public class B2304_창고다각형 {
    static class Info implements Comparable<Info>{
        int l, h;
        Info(int l, int h){
            this.l = l;
            this.h = h;
        }

        @Override
        public int compareTo(Info o) {
            if (this.l < o.l) {
                return -1;
            } else if (this.l > o.l) {
                return 1;
            }
            return 0;
        }
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int area = 0;
        ArrayList<Info> arr = new ArrayList<>();
        for(int i = 0; i < N; i++){
            arr.add(new Info(sc.nextInt(), sc.nextInt()));
        }
        Collections.sort(arr);

        Info before = arr.get(0);
        for(int i = 1; i < arr.size(); i++){
            if(before.h <= arr.get(i).h){
                area += (arr.get(i).l - before.l) * before.h;
                before = arr.get(i);
            }
            if (i == arr.size() - 1){
                int tmp1 = (arr.get(i).l - before.l + 1) * before.h;
                int tmp2 = (before.h - arr.get(i).h) * ( arr.get(i).l - before.l) ;
                area += (tmp1 - tmp2);
            }
        }
        System.out.println(area);
    }
}
