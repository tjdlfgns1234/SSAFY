import java.io.*;
import java.util.*;

public class Solution {

	static int n = 1;
	static long ans = 0;
	static int[] arrx = new int[11]; 
	static int[] arry = new int[11]; 
	static boolean[] chk = new boolean[11];
	static int[] company = new int[2];
	static int[] home = new int[2];
//	static int[] dx = {-1,1,0,0};
//	static int[] dy = {0,0, 1,-1};
// 
	// static int[][] map = new int[n][n];
	
	/*
	 * 현재 선택이 미래의 선택에 영향을 주면 그리디 안됨!
	 * 
	 * */
	
	
	public static void main(String[] args) {
		// System.setIn(Solution.class.getResourceAsStream("text.txt"));
		Scanner sc = new Scanner(System.in);
	
		int T = sc.nextInt();
	
		for(int testcase = 0; testcase < T;testcase++) {
			ans = 987654321;
			n = sc.nextInt();
			company[0] = sc.nextInt();
			company[1] = sc.nextInt();
			home[0] = sc.nextInt();
			home[1] = sc.nextInt();
			
			for(int i = 0; i < n;i++) {
				arrx[i] = sc.nextInt();
				arry[i] = sc.nextInt();
			}
			solve();
			System.out.println("#" + (testcase+1) + " " + ans);
		}
	}

	public static void solve() {
		pickGuest(0, new int[n]);
	}

	public static void pickGuest(int cnt, int[] sel) {
		if(cnt == n) {
			calc(sel);
			return;
		}
		
		for(int i =0; i< n;i++) {
			if(chk[i] == false) {
				chk[i] = true;
				sel[cnt] =i; 
				pickGuest(cnt+1,sel);
				chk[i] = false;
			}
		}
		
		
	}
	public static void calc(int[] sel) {
		int sum = 0;
		
		sum += dist(company[0],company[1],arrx[sel[0]],arry[sel[0]]);
		for(int i = 1; i < n;i++) 
			sum+=dist(arrx[sel[i-1]],arry[sel[i-1]],arrx[sel[i]],arry[sel[i]]);
		sum += dist(home[0],home[1],arrx[sel[n-1]],arry[sel[n-1]]);
		ans = Math.min(ans, sum);
	}
	
	public static int dist(int x, int y, int x2, int y2) {
		return Math.abs(x-x2) + Math.abs(y - y2);
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
