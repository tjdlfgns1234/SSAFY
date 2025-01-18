import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String agrs[]) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		
		if (n <= 100 && n > 0 && m < 5 && m > 0 && n % 2 == 1) {
			if (m == 1) {
				for (int i = 0; i < (n / 2 + 1); i++) {
					for (int j = 0; j <= i; j++) {
						System.out.print("*");
					}
					System.out.println();
				}
				for (int i = (n / 2) ; i > 0; i --) {
					for (int j = i; j > 0; j--) {
						System.out.print("*");
					}
					System.out.println();
				}
			}
			else if (m == 2) {
				for (int i = 0; i < (n / 2 + 1); i++) {
					for (int k = i; k < (n/2); k++) {
						System.out.print(" ");
					}
					for (int j = 0; j <= i; j++) {
						System.out.print("*");
					}
					System.out.println();
				}
				for (int i = (n / 2) ; i > 0; i --) {
					for (int k = 0; k < (n / 2 + 1 - i); k++ ) {
						System.out.print(" ");
					}
					for (int j = i; j > 0; j--) {
						System.out.print("*");
					}
					System.out.println();
				}
			}
			else if (m == 3) {
				for (int i = 0; i < (n/ 2 + 1); i++) {
					for (int k = 0; k < i; k++) {
						System.out.print(" ");
					}
					for (int j = n; j >= (i * 2 + 1); j--) {
						System.out.print("*");
					}
					System.out.println();
				}
				for (int i = n / 2; i > 0; i--) {
					for (int k = 0; k < i - 1; k++) {
						System.out.print(" ");
					}
					for (int j = 0; j < (n - (i-1) * 2); j++) {
						System.out.print("*");
					}
					System.out.println();
				}
			}
			else if (m == 4) {
				for (int i = (n / 2) + 1 ; i > 0; i --) {
					for (int k = 0; k < (n / 2 + 1 - i); k++ ) {
						System.out.print(" ");
					}
					for (int j = i; j > 0; j--) {
						System.out.print("*");
					}
					System.out.println();
				}
				for (int i = 0; i < n / 2; i++) {
					for (int k = 0; k < n/ 2; k++) {
						System.out.print(" ");
					}
					for (int j = 0; j < i + 2; j++) {
						System.out.print("*");
					}
					System.out.println();
				}
			}
		}
		else {
			System.out.println("INPUT ERROR!");
		}
		
	}
}
