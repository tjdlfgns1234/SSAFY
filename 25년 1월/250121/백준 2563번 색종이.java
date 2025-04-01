import java.io.*;
import java.util.*;

public class Main {

	static int cnt = 1;
	static int[][] arr = new int[101][101];

	// static int[][] map = new int[n][n];
	
	public static void main(String[] args) {
		// System.setIn(Solution.class.getResourceAsStream("text.txt"));
		Scanner sc = new Scanner(System.in);
	
		int t = sc.nextInt();
	
		for(int i = 0; i < t;i++) {
			int x = sc.nextInt();
			int y = sc.nextInt();
			
			
			for(int j = x; j <= x+9;j++)
				for(int k = y; k<= y+9;k++) {
					arr[j][k]++;
				}
		
		
			
		}
		int ans = 0;
		for(int j = 0; j < 100;j++) 
			for(int k = 0; k< 100;k++) 
				if(arr[j][k] != 0)
					ans++;
		
		System.out.print(ans);
	}
	
	public static void print(int n) {
		for(int j = 0; j < n;j++) {
			for(int k = 0; k< n;k++) 
				System.out.print(arr[j][k]+" ");
			System.out.println();
		}		
		
	}
	
//	public static void solve(int n) {
//			for(int i = 0; i < n-1;i++) {
//				if(arr[i+1] - arr[i] < 0) // 내려가기
//					low = Math.max(low, Math.abs(arr[i] - arr[i+1]));
//				if(arr[i+1] - arr[i] > 0) // 올라가기
//					high = Math.max(high, Math.abs(arr[i] - arr[i+1]));
//			}
//	}
}
