package com.algorithm.swexpert;

import java.util.Scanner;
 
public class S8556_북북서 {
    static int count = 0, cnt = 0;
    static double a;
 
    public static void main(String[] args) {
        // TODO Auto-generated method stub
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
 
        for (int tc = 1; tc <= T; tc++) {
            count = 0; cnt = 0; a = 0.0;        // 초기화
            String dir = sc.next();             // ex) northwest
            dir = reverse(dir);                 // 입력받은 문자열 뒤집기
                                                // ex) tsewhtron
             
            while (dir.length() != 0) {         // 문자열의 길이가 0이 될때까지
                if (dir.charAt(0) == 't') {     // 첫번째 문자가 t이면 -> west를 의미
                    if (count == 0) {
                        a = 90;
                        dir = dir.replaceFirst("tsew", ""); // tsew(west) 문자열 없애기
                    } else {
                        a = a + (90 / Math.pow(2, count));
                        dir = dir.replaceFirst("tsew", "");
 
                    }
                    count++;
                } else if (dir.charAt(0) == 'h') { // 첫번째 문자가 h이면 -> north를 의미
                    if (count == 0) {
                        a = 0;
                        dir = dir.replaceFirst("htron", ""); // htron(north) 문자열 없애기
                    } else {
                        a = a - (90 / Math.pow(2, count));
                        dir = dir.replaceFirst("htron", "");
                    }
                    count++;
                }
            }
 
            while (a - (int) a != 0) { 
                a *= 2;
                cnt++;
            }
            if (cnt < 1) {
                System.out.println("#" + tc + " " + (int) a);
            } else {
                System.out.println("#" + tc + " " + (int) a + "/" + (int)Math.pow(2, cnt));
            }
        }
    }
 
    private static String reverse(String dir) {
        // TODO Auto-generated method stub
        String str = "";
        for (int i = dir.length() - 1; i >= 0; i--) {
            str += dir.charAt(i);
        }
        return str;
    }
}