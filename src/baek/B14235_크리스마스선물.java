package baek;

import java.util.Collections;
import java.util.PriorityQueue;
import java.util.Scanner;

public class B14235_크리스마스선물 {
    static PriorityQueue<Integer> gift = new PriorityQueue<>(Collections.reverseOrder());
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        for(int i = 0; i < n; i++){
            int a = sc.nextInt();
            if(a == 0){
                if(gift.size() == 0){
                    System.out.println(-1);
                }else{
                    int c = gift.poll();
                    System.out.println(c);
                }
            }else{
                for(int j = 0; j < a; j++){
                    int b = sc.nextInt();
                    gift.add(b);
                }
            }
        }
    }
}
