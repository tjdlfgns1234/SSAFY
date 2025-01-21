import java.io.*;
import java.util.*;

public class Solution {

	static int ans = 0;
	static int v = 0;
	static int cnt = 1;
	static int[][] arr = new int[21][21];

	// static int[][] map = new int[n][n];
	
	public static void main(String[] args) {
		// System.setIn(Solution.class.getResourceAsStream("text.txt"));
		Scanner sc = new Scanner(System.in);
	
		int t = sc.nextInt();
	
		for(int i = 0; i < t;i++) {
			ans = 0;v =0; //  초기화
			
			int n = sc.nextInt();
			int m = sc.nextInt();
			
			for(int j = 0 ; j < n;j++)
				for(int k = 0; k < m;k++)
					arr[j][k] = sc.nextInt();
			
			solve(n, m);
			
			System.out.println("#" + cnt++  + ' ' + ans + " " + v);
		
		}
		

		
	}
	
	public static void solve(int n, int m) {
		int[] man = new int [21];
		
		for(int i = 0 ; i < n;i++)
			for(int j = 0; j < m;j++)
				man[i] +=arr[i][j];
		
		
		for(int i = 0 ; i < n;i++) {
			if(man[i] > v) {
				v = man[i];
				ans = 1;
			}
			else if(man[i] == v)
				ans++;
			
		}
		
	}
}
