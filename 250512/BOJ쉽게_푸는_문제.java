import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Scanner;

class BOJ쉽게_푸는_문제 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int m = sc.nextInt();

		int[] arr = new int[m];

		int num = 1;
		int cnt = 1;

		for (int i = 0; i < m; i++) {
			arr[i] = num;

			if (cnt == num) {
				cnt = 1;
				num += 1;
			} else {
				cnt++;
			}
		}

		int sum = 0;
		n -=1;
		m -=1;
		for (int i = n; i <= m; i++) {
			sum += arr[i];
		}

		System.out.println(sum);
	}

}