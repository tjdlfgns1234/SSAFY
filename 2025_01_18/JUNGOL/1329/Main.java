import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String agrs[]) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		if (n <= 100 && n > 0 && n % 2 == 1) {
			for (int i = 0; i < (n / 2 + 1); i++) {
				for (int k = 0; k < i; k++) {
					System.out.print(" ");
				}
				for (int j = 0; j < (i * 2 + 1); j++) {
					System.out.print("*");
				}
				System.out.println();
			}
			for (int i = n / 2; i > 0; i--) {
				for (int k = 0; k < i - 1; k++) {
					System.out.print(" ");
				}
				for (int j = 0; j < (i * 2 - 1); j++) {
					System.out.print("*");
				}
				System.out.println();
			}
		}
		else {
			System.out.println("INPUT ERROR!");
		}
		
	}
}
