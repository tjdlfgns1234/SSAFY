import java.io.*;
import java.util.*;

public class Solution {

	static int n = 1;
	static long ans = 0;
	static int[] arr = new int[1000001];
//	static int[] dx = {-1,1,0,0};
//	static int[] dy = {0,0, 1,-1};
// 
	// static int[][] map = new int[n][n];
	
	/*
	 * 현재 선택이 미래의 선택에 영향을 주면 그리디 안됨!
	 * 
	 * */
	
	public static void main(String[] args) {
		System.setIn(Solution.class.getResourceAsStream("text.txt"));
		Scanner sc = new Scanner(System.in);
	
		int T = sc.nextInt();
	
		for(int testcase = 0; testcase < T;testcase++) {
			ans = 0;
			n = sc.nextInt();
					
			for(int i = 1; i <= n;i++) 
				arr[i] = sc.nextInt();
			
			solve();
			System.out.println("#" + (testcase+1) + " " + ans);
		}
		
		
	}

	public static void solve() {
        // 뒤에서 부터 탐색하면 쉽게 구할 수 있다.
		long prefix = arr[n];
		int l = n;
		
		for(int i = n-1; i >= 1; i--) {
			if(arr[l]<arr[i]) {
				ans+= arr[l]*((long)l-i) - prefix;
				prefix = arr[i];
				l = i;
			}
			else
				prefix += arr[i];
		}
		if(l!= 1) {
			ans+= arr[l]*((long)l) - prefix;
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
