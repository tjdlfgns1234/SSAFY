import java.util.*;
import java.io.*;

class Pair{
	int x,y;
	
	Pair(){
	}
	
	Pair(int x,int y){
		this.x = x;
		this.y = y;
	}
}

public class Main {
    static int n,k, cnt = 1;
    static int[][] dp = new int[101][100001];
    static int[] arr;
    static final int INF = 987654321;
    static StringBuilder sb = new StringBuilder();
    static BufferedReader br;
    static StringTokenizer st;
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    
 
	public static void main(String[] args) throws IOException {
		br = new BufferedReader(new InputStreamReader(System.in));
	    // st = new StringTokenizer(br.readLine());
		
	    int t =1;
	
	    for(int testcase = 1; testcase<= t; testcase++) {
			st =  new StringTokenizer(br.readLine());
	        n = Integer.parseInt(st.nextToken());
	        k = Integer.parseInt(st.nextToken());
	
	        arr = new int[n+1];
	    	// 1부터 시작이야!
	    	st =  new StringTokenizer(br.readLine());
	    	for(int i = 1; i <= n;i++) {
	    		arr[i] = Integer.parseInt(st.nextToken());
	    	}

	    	// Arrays.sort(arr);
	        solve();

	        if(k == 0)
	        	dp[n][k] = 0;
	        System.out.print((dp[n][k]==INF?-1:dp[n][k]));
		  }
	}

    public static void solve() throws IOException {
    	// 0으로 초기화야!
    	for(int i = 0; i <= n;i++)
    		Arrays.fill(dp[i], INF);

    	
    	for(int i = 1; i <= n;i++) {
    		for(int j = 1; j <= k;j++) 
    			if(j - arr[i] >= 0) {
    				if(j - arr[i] == 0)
    					dp[i][j] = 1;
    				else if(dp[i-1][j-arr[i]] != INF)
    					dp[i][j] = Math.min(dp[i-1][j-arr[i]] + 1,dp[i-1][j]);
    				else
    					dp[i][j] = Math.min(dp[i][j],dp[i-1][j]);
    			}
    			else
    				dp[i][j] = Math.min(dp[i][j],dp[i-1][j]);			
    	}
    	
//    	for(int i = 1; i <= n;i++) {
//    		for(int j = 1; j <= k;j++) 
//    			System.out.print((dp[i][j]==INF?0:dp[i][j]) + " ");
//    		System.out.println();
//    	}
// 	
    }

}
