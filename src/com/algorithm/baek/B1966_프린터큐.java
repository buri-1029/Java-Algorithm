package com.algorithm.baek;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class B1966_프린터큐 {
    static class Printer implements  Comparable<Printer>{
        private int index;
        private int priority;
        public Printer(int index, int priority){
            this.index = index;
            this.priority = priority;
        }

        @Override
        public int compareTo(Printer o) {
            return o.priority - this.priority;
        }
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt(); // 테스트케이스의 수

        for(int tc = 0; tc < T; tc++){
            Queue<Printer> queue = new LinkedList<>();
            int N = sc.nextInt(); // 문서의 개수
            int M = sc.nextInt(); // 궁금한 문서
            int cnt = 0; // 현재 몇 번째 순서인가

            for(int i = 0; i < N; i++){
                // 순서와 중요도 저장
                queue.add(new Printer(i, sc.nextInt()));
            }

            while(!queue.isEmpty()){
                Printer p = queue.poll(); // 가장 앞에있는 문서
                boolean isOk = false ;
                for(Printer tmp : queue){
                    /// 현재 문서보다 중요도가 높은 순서가 하나라도 있다면
                    if(p.priority < tmp.priority){
                        isOk = true;
                        break;
                    }
                }
                if(isOk){ // 인쇄하지 않고 뒤로 재배치
                    queue.add(new Printer(p.index,p.priority));
                }else{
                    cnt++; // 그렇지 않으면 순서(cnt)증가
                    if(p.index == M){ // 현재 문서가 궁금한 문서이면
                        System.out.println(cnt); // 순서 출력
                        break;
                    }
                }
            }
        }
    }
}
