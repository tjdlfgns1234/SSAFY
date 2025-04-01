import java.io.*;
import java.util.*;

public class Solution {
	
	static int n = 9;
	static int cnt = 1;
	static int[][] map = new int[n][n];
	
	public static void main(String[] args) {
		// System.setIn(Solution.class.getResourceAsStream("test2.txt"));
		
		Scanner sc = new Scanner(System.in);

		int t = sc.nextInt();
		// int n = sc.nextInt();

		for(int i = 0; i < t;i++) {
			for ( int k = 0 ; k < n ; k++ ) {
				for ( int j = 0 ; j < n ; j++ ) {
					map[k][j] = sc.nextInt();
				}
			}	
			solve();
		}
		

	}
	
	private static void solve() {
		for(int i = 0; i < n;i++) {
			for(int j = 0; j < n;j++) {
				if(checkCol(i,j) == false) {
					System.out.println("#" + cnt++ + " " + 0);
					return;
				}
				if(checkRow(i,j) == false) {
					System.out.println("#" + cnt++ + " " + 0);
					return;
				}
			}
		}
		
		int[] dx = {0, 3, 6, 0, 3,6, 0,3,6};
		int[] dy = {0, 0, 0, 3, 3,3, 6,6,6};
		
		for(int i = 0; i < dx.length;i++)
			if(checkBox(dx[i], dy[i]) == false){
				System.out.println("#" + cnt++ + " " + 0);
				return;
			}
				
		System.out.println("#" + cnt++ + " " + 1);
			
	}
	private static boolean checkCol(int x, int y) {
		int[] arr = new int[9];
		
		for(int i = 0; i <9;i++)
			arr[map[i][y]-1] = 1;
		
		for(int i = 0; i <9;i++)
			if(arr[i] == 0)
				return false;
		
		return true;
	}
	
	
	private static boolean checkRow(int x, int y) {
		int[] arr = new int[9];
		
		for(int i = 0; i <9;i++)
			arr[map[x][i]-1] = 1;
		
		for(int i = 0; i <9;i++)
			if(arr[i] == 0)
				return false;
		
		return true;
	}
	
	
	
	private static boolean checkBox(int x, int y) {
		int n = 3;
		int[] arr = new int[9];
		
		for(int i = 0; i <n;i++)
			for(int j = 0; j < n;j++)
				arr[map[i][j]-1] = 1;
		
		for(int i = 0; i <n;i++)
			if(arr[i] == 0)
				return false;
		
		return true;
	}
	
}
