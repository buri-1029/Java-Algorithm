package baek.silver;

import java.util.Scanner;

public class B1292_쉽게푸는문제 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int A = sc.nextInt();
		int B = sc.nextInt();

		int ans = 0, num = 1, cnt = 1, idx = 1;
		while (true) {
            if (idx >= A) {
                ans += num;
            }
            if (idx == B) {
                break;
            }
			if (num == cnt) {
				num++;
				cnt = 0;
			}
			cnt++;
			idx++;
		}
		System.out.println(ans);
	}
}
