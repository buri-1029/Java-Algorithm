package baek.silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class B10610_30 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String n = br.readLine();
		String[] s = n.split("");

		if (n.contains("0")) {
			int[] arr = new int[s.length];
			int sum = 0;

			for (int i = 0; i < arr.length; i++) {
				arr[i] = Integer.parseInt(s[i]);
				sum += arr[i];
			}

			if (sum % 3 == 0) {
				Arrays.sort(arr);
				for (int i = arr.length - 1; i >= 0; i--) {
					System.out.print(arr[i]);
				}
			} else {
				System.out.println(-1);
			}
		} else {
			System.out.println(-1);
		}

	}
}
