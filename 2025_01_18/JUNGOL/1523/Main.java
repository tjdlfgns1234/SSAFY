import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String agrs[]) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		
		if (n <= 100 && n > 0 && m < 4 && m > 0) {
			if (m == 1) {
				for (int i = 0; i < n; i++) {
					for (int j = 0; j <= i; j++) {
						System.out.print("*");
					}
					System.out.println();
				}
			}
			else if (m == 2) {
				for (int i = n; i > 0; i--) {
					for (int j = 0; j < i; j++) {
						System.out.print("*");
					}
					System.out.println();
				}
			}
			else if (m == 3) {
				for (int i = 0; i < n; i++) {
					for (int j = n - 1; j > i; j--) {
						System.out.print(" ");
					}
					for (int j = 0 ; j < (2 * i + 1) ; j++) {
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
