import java.io.*;
import java.util.*;

class Pair{
	int x,y;
	
	Pair(){
	}
	
	Pair(int x,int y){
		this.x = x;
		this.y = y;
	}
}

public class Solution {
    static int n,k, cnt = 1;
    static int[][] dp = new int[101][1001];
    static StringBuilder sb = new StringBuilder();
    static BufferedReader br;
    static StringTokenizer st;
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    
    public static void main(String[] args) throws IOException {
		// System.setIn(Main.class.getResourceAsStream("/Algorithm/input2.txt"));
		br = new BufferedReader(new InputStreamReader(System.in));
	    st = new StringTokenizer(br.readLine());
		
	    int t =Integer.parseInt(st.nextToken());

	    for(int testcase = 1; testcase<= t; testcase++) {
			st =  new StringTokenizer(br.readLine());
	        n = Integer.parseInt(st.nextToken());
	        k = Integer.parseInt(st.nextToken());

	        solve();
	        
	        sb.append("#" + testcase + " " + dp[n][k] + '\n');
		  }
	    bw.write(sb.toString());
	    bw.flush();
    }

    public static void solve() throws IOException {
        
    	// 0으로 초기화야!
    	for(int i = 0; i <= n;i++)
    		Arrays.fill(dp[i], 0);

    	
    	Pair[] mp = new Pair[n+1];
    	
    	for(int i = 0; i <= n;i++)
    		mp[i] = new Pair();
    	
    	// 1부터 시작이야!
    	for(int i = 1; i <= n;i++) {
			st =  new StringTokenizer(br.readLine());
    	    mp[i].x = Integer.parseInt(st.nextToken());
   	        mp[i].y = Integer.parseInt(st.nextToken());
    		
    	}
    	
    	for(int i = 1; i <=n;i++) {
    		for(int j = 1; j <= k;j++) {
    			if(j - mp[i].x >= 0)
    				dp[i][j] = Math.max(dp[i-1][j],dp[i-1][j-mp[i].x] + mp[i].y);
    			else
    				dp[i][j] = Math.max(dp[i-1][j], dp[i][j-1]);
    		}
    	}
    }
	
}