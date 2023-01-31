package baek.bronze;

import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.Stream;

public class B1551_수열의변화 {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);

		int N = scan.nextInt();
		int K = scan.nextInt();
		String sequence = scan.next();

		int[] arr = Stream.of(sequence.split(","))
						  .mapToInt(Integer::parseInt)
						  .toArray();

		int[] new_arr = Arrays.copyOf(arr, arr.length);
		int len = N - 1;

		while (K != 0) {
			int[] tmp_arr = new int[len];

			for (int i = 0; i < new_arr.length - 1; i++) {
				tmp_arr[i] = new_arr[i + 1] - new_arr[i];
			}

			len--;
			K--;
			new_arr = Arrays.copyOf(tmp_arr, tmp_arr.length);
		}

		for (int i = 0; i < new_arr.length; i++) {
			if (i != new_arr.length - 1) {
				System.out.print(new_arr[i] + ",");
			} else {
				System.out.println(new_arr[i]);
			}
		}
	}
}
