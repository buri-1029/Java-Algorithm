package baek;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class B16509_장군 {
    static int R1, C1, R2, C2, ANS;
    static int[] dr = {-3, -2, 2, 3, -3, -2, 2, 3};
    static int[] dc = {-2, -3, -3, -2, 2, 3, 3, 2};
    static class Point{
        int r, c;

        Point(int r, int c) {
            this.r = r;
            this.c = c;
        }
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        R1 = sc.nextInt(); // 상
        C1 = sc.nextInt();
        R2 = sc.nextInt(); // 왕
        C2 = sc.nextInt();

        bfs(R1, C1);

    }

    private static void bfs(int r1, int c1) {
        Queue<Point> queue = new LinkedList<>();
        Boolean[][] visited = new Boolean[10][9];
    }
}
