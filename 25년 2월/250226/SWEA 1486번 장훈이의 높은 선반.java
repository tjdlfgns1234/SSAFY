import java.io.*;
import java.util.*;

class Pair {
	int x,y;
	
	Pair(){}
	
	Pair(int x,int y){
		this.x = x;
		this.y = y;
	}
}


public class Solution {
	static int n, m;
	static Pair start;
	static int []arr;
 	static int ans = 0, q;
	static int test = 0;	
    static BufferedReader br;
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
    	// st = new StringTokenizer(br.readLine());
        int T = Integer.parseInt(br.readLine());
        // int T = 10;
        for (int testcase = 1 ; testcase <= T ; testcase++) {
    		st = new StringTokenizer(br.readLine());
        	n = Integer.parseInt(st.nextToken());
          	m = Integer.parseInt(st.nextToken());
        	arr = new int[n];
        	st = new StringTokenizer(br.readLine());
        	for(int i = 0; i < n;i++) 
        			arr[i] = Integer.parseInt(st.nextToken());
        
        	ans = 987654321;
            solve();
           
        	// System.out.println(test);
        	
        	sb.append("#" + testcase + " " + ans +  "\n");
        }
        System.out.print(sb.toString());
    }
    
    public static void solve() {
    	dfs(new boolean[n],0,0);
    }

	private static void dfs(boolean[] sel, int idx, int sum) {
		if(idx == n) {

			if(sum >= m)
				ans = Math.min(ans, sum - m);
			
			return;
		}
		
		
		sel[idx] = true;
		dfs(sel,idx+1,sum + arr[idx]);
		sel[idx] = false;
		dfs(sel,idx+1,sum);
		
	}
}
