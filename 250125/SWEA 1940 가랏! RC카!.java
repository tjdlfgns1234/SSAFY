import java.io.*;
import java.util.*;

public class Solution {

	static int n = 1;
	static int curr = 0;
	static int ans = 0;
    static Scanner sc = new Scanner(System.in);
//	static int[] dx = {-1,1,0,0};
//	static int[] dy = {0,0, 1,-1};
// 
	// static int[][] map = new int[n][n];
	// 햄버거 다이어트
	
	public static void main(String[] args) {
		// System.setIn(Solution.class.getResourceAsStream("text.txt"));
		int t = sc.nextInt();
	
		for(int i = 1; i <= t;i++) {
			ans = 0;
            curr = 0;
			n = sc.nextInt();

            for(int j = 0; j < n;j++)
                solve();
            
			System.out.println("#" + i + " " + ans);
		}
	}

	public static void solve() {
		int op = sc.nextInt();
        int ac;
       
        if(op !=  0){
            ac = sc.nextInt();
           // System.out.println("# " + ac + " " + ans + " " + curr);
            if(op == 1){  // 가속
                ans += curr + ac;
                curr+= ac;
            }
            else if (op == 2){ // 감속
                ans += Math.max(curr - ac,0);
                curr = Math.max(curr - ac,0);
            }

        }
        else{ // 변화 없음
            // 매초 당 1개의 커맨드
            ans += curr; 
        }
        
	}
}
