import java.io.*;
import java.util.*;

public class Solution {

	static int n = 1;
	static int l = 0;
	static int ans = 0;
	static int[] arr = new int[20];
	static int[] arr2 = new int[20];
//	static int[] dx = {-1,1,0,0};
//	static int[] dy = {0,0, 1,-1};
// 
	// static int[][] map = new int[n][n];
	// 햄버거 다이어트
	
	public static void main(String[] args) {
		// System.setIn(Solution.class.getResourceAsStream("text.txt"));
		Scanner sc = new Scanner(System.in);
	
		int t = sc.nextInt();
	
		for(int i = 0; i < t;i++) {
			ans = 0;
			n = sc.nextInt();
			l = sc.nextInt();
					
			for(int j = 0; j < n;j++) {
				arr[j] = sc.nextInt();
				arr2[j] = sc.nextInt();
			}			
			recursive(0, 0, new int[20]);
			System.out.println("#" + (i+1) + " " + ans);
		}
		
		
	}

	public static void recursive(int idx, int cnt, int[] chk) {
		if(sum(chk, cnt) <= l) {
			ans = Math.max(ans, sum2(chk,cnt));
		}
		
		if(sum(chk,cnt) > l)
			return;
		
		if(idx >= n)
			return;
		
		// 현재 단계 선택
		chk[cnt] = idx; 
		recursive(idx+1,cnt+1,chk);
		
		// 현재 단계 선택 X
		recursive(idx+1,cnt,chk);
		
	}
	
	public static int sum(int[] chk, int cnt) {
		int ret = 0;
		for(int i = 0; i < cnt; i++)
			ret += arr2[chk[i]];
		return ret;
	}
	
	public static int sum2(int[] chk, int cnt) {
		int ret = 0;
		for(int i = 0; i < cnt; i++)
			ret += arr[chk[i]];
		return ret;
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
