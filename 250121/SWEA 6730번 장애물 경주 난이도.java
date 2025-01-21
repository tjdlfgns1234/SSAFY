import java.io.*;
import java.util.*;

public class Solution {

	static int high = 0; // 올라갈떄 높이차
	static int low = 0; // 내려갈떄 높이차
	static int cnt = 1;
	static int[] arr = new int[101];

	// static int[][] map = new int[n][n];
	
	public static void main(String[] args) {
		// System.setIn(Solution.class.getResourceAsStream("text.txt"));
		Scanner sc = new Scanner(System.in);
	
		int t = sc.nextInt();
	
		for(int i = 0; i < t;i++) {
			high = 0;low =0; //  초기화
			
			int n = sc.nextInt();
			for(int j = 0 ; j < n;j++)
				arr[j] = sc.nextInt();
			
			solve(n);
			
			System.out.println("#" + cnt++  + ' ' + high + " " + low);
		
		}
		
	}
	
	public static void solve(int n) {
			for(int i = 0; i < n-1;i++) {
				if(arr[i+1] - arr[i] < 0) // 내려가기
					low = Math.max(low, Math.abs(arr[i] - arr[i+1]));
				if(arr[i+1] - arr[i] > 0) // 올라가기
					high = Math.max(high, Math.abs(arr[i] - arr[i+1]));
			}
	}
}
