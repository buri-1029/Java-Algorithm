package baek;

import java.util.Scanner;

public class B2974_나무조각 {
    static int N = 5;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[] arr = new int[N];
        for (int i = 0; i < N; i++) {
            arr[i] = sc.nextInt();
        }

       for(int i = 0; i < N; i++){ // 다섯번 모두 돌면서
           for(int j = 0; j < N - 1; j++){ 
               if(arr[j] > arr[j + 1]){
                   int tmp = arr[j];
                   arr[j] = arr[j + 1];
                   arr[j + 1] = tmp;
                   for(int k = 0; k < N; k++){
                       System.out.print(arr[k]+" ");
                   }
                   System.out.println();
               }
           }
       }
    }
}
