import java.io.*;
import java.util.*;

public class Solution {
	
	static int n = 0;
	static int cnt = 1;

	// static int[][] map = new int[n][n];
	
	public static void main(String[] args) {
		// System.setIn(Solution.class.getResourceAsStream("test2.txt"));
		Scanner sc = new Scanner(System.in);


		int t = sc.nextInt();
		// int n = sc.nextInt();

		for(int i = 0; i < t;i++) {
			n = sc.nextInt();
			int[] dp = new int[5001];
            
            int x;
			int y;
			
            
            
			for(int j = 0; j < n;j++) {
				x = sc.nextInt();
				y = sc.nextInt();
				// System.out.println(x + " " + y );
				for(int l = x; l <= y;l++)
					dp[l]++;
			}
			
			
			System.out.print("#" + cnt++ + " " );
			
			int p = sc.nextInt();
			
			int q;
			for(int j = 0; j < p;j++) {
				q = sc.nextInt();
				System.out.print(dp[q] + " ");
			}
				
			System.out.println();
		}
		

	}
	
//	public static void solve() {
//
//			
//	}
}
