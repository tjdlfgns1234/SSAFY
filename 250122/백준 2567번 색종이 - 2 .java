import java.io.*;
import java.util.*;

public class Solution {

	static int cnt = 1;
	static int ans = 0;
	static int[][] arr = new int[101][101];
	static int[] dx = {-1,1,0,0};
	static int[] dy = {0,0, 1,-1};
 
	// static int[][] map = new int[n][n];
	
	
	public static void main(String[] args) {
		System.setIn(Solution.class.getResourceAsStream("text.txt"));
		Scanner sc = new Scanner(System.in);
	
		int t = sc.nextInt();
	
		for(int i = 0; i < t;i++) {
			int x = sc.nextInt();
			int y = sc.nextInt();
			
			
			for(int j = x; j <= x+9;j++)
				for(int k = y; k<= y+9;k++) 
					arr[j][k]++;
					
		}
		
		
		bfs();
		// print(30);
		System.out.print(ans);
	}
	
	public static void print(int n) {
		for(int j = 0; j < n;j++) {
			for(int k = 0; k< n;k++) 
				System.out.print(arr[j][k]+" ");
			System.out.println();
		}		
		
	}

	public static void bfs() {
		int n = 101;
		for(int i = 1; i < n;i++)
			for(int j = 1; j < n;j++)
				if(arr[i][j] != 0) {
					int a = 0;
					
					for(int l = 0; l < 4; l++) {
						int nx = i + dx[l];
						int ny = j + dy[l];
						
						if(nx < 0 || nx>=n || ny < 0 || ny >= n || arr[nx][ny] != 0)
							continue;
						a++;
					}
					
					ans+= a;		
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
